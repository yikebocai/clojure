(ns org.bocai.myclj.dumpexcel
  (:use [dk.ative.docjure.spreadsheet]))

(defn dump [myfile]
  (let [cols (->> (load-workbook myfile)
               (select-sheet "sheet1")
               (select-columns {:A :BU, :B :Event,:C :Important,:D :Type,:E :Site,:F :QUEUE,:G :IsTopic,:H :TopicName}))
        cnt (count cols)]
    (dotimes [x cnt]
      (let [row (nth cols x)
            bu (:BU row)
            event (:Event row)
            important (if (:Important row)  (:Important row) " ")
            type (if (nil? (:Type row) ) " " (:Type row))
            site (if (nil? (:Site row) ) " " (:Site row))
            queue (if (nil? (:QUEUE row)   ) " " (:QUEUE row))
            isTopic (if (nil? (:IsTopic row)  ) " " (:IsTopic row))
            topicName (if (nil? (:TopicName row)) " " (:TopicName row))]
        (println (str "|" bu "|" event "|" important "|" type "|" site "|" queue "|" isTopic "|" topicName "|"))))
    ))

(dump "/Users/zxb/Desktop/b2b_event.xlsx")

