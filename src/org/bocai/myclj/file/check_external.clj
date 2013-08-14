;;check com.alibaba.external in pom
(ns org.bocai.myclj.file.check_external
  (:use [clojure.xml]
        [clojure.java.shell :only [sh]]))

(defn check-pom [path]
  (let [myxml (parse path)
        project (content myxml)
        dependencyManagement (filter #(= (str (tag %)) ":dependencyManagement") project)
        dependencies (content (first (content (first dependencyManagement))))]
    (dotimes [x (count dependencies)]
      (let [dependency (content (nth dependencies x))
            groupId (first (content (first (filter #(= ":groupId" (str (tag %))) dependency))))
            artifactId (first (content (first (filter #(= ":artifactId" (str (tag %))) dependency))))
            version (first (content (first (filter #(= ":version" (str (tag %))) dependency))))]
        (if (= groupId "com.alibaba.external")
          (do
            (println "gid:" groupId)
            (println "aid:" artifactId)
            (println "version:" version)
            (println "")
            ))))))

(defn find-pom [path]
  (let [out (:out (sh "sh" "-c" (str "find " path "|grep -v target|grep pom.xml$")))
        arr (clojure.string/split out #"\n")]
    (dotimes [x (count arr)]
      (let [pomfile (nth arr x)]
        (do
          (println pomfile)
          (check-pom pomfile)
          )
        ))))

 (find-pom "/Users/zxb/work/intl-riskbops")