(use 'clojure.java.jdbc)

;设置端口和数据库名称的值
(let [db-host "localhost"
      db-port 3306 ; 3306
      db-name "risk"]

  ; 定义Msql连接属性
  (def db {:classname "com.mysql.jdbc.Driver"
           :subprotocol "mysql"
           :subname (str "//" db-host ":" db-port "/" db-name)
           :user "root"
           :password "hello1234"})

  ;数据库插入
  (with-connection db
    (insert-records :test
      {:id 10 :name "Tom"}
      {:id 11 :name "Jack"}))

  ;数据库查询
  (with-connection db ; 创建一个连接
    (with-query-results rs ["select * from test"] ;执行一条SQL
      (doseq [row rs]      ;遍历ResultSet，打印结果
        (println  (row :id) ":" (row  :name))))))
