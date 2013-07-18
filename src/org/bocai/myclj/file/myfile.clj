(require '[clojure.java.io :as io])

;;追加写入文件
(defn appendFile [fileName content]
  (binding [*out* (java.io.FileWriter. fileName true)]
    (println content)
    (flush)))

(appendFile "my.log" "hello,bob")
(appendFile "my.log" "hello,zhang")

;;按行读取文件中的内容，并放到List中
(defn read-file-into-list [fileName]
  (with-open [rdr (io/reader fileName)]
    (doall (line-seq rdr))))

(println (read-file-into-list "my.log"))

;;打印文件中的每一行内容
(defn printFile [fileName]
  (with-open [rdr (io/reader fileName)]
    (doseq [line (line-seq rdr)]
      (println line))))

(println "---------")
(printFile "my.log")