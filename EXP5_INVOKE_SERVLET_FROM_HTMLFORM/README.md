# Invoking Servlet from HTML Forms.

Doing a login form with cookies functionality and a database backend.

Dynamic Pages created using Java Servlets.

## Prerequisites 
+ `Apache Tomcat 10` as webserver, 
+ `MySQL` for the database, 
+ `mysql-connector-java-8.0.27` from [here](https://dev.mysql.com/downloads/connector/j/) 
for universal database connectivity.

+ Create and fill all the necessary environmental variables for proper functioning of webserver.
+ Add `servlet-api.jar` in `TOMCAT_ROOT/lib/` and `mysql-connector-java-8.0.27.jar` you just downloaded to `CLASSPATH` env variable.
+ The above isn't necessary but will make compiling the java source code easier, or else you can just do
  > `javac -cp ./path/to/servlet-api.jar ./path/to/mysql-connector.jar ./path/to/java/sourcfile.java`

## Database creation
```
mysql> create databases login;
mysql> use login;
Database changed
mysql> create table users(name varchar(255), password varchar(30));
mysql> desc users;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| name     | varchar(255) | YES  |     | NULL    |       |
| password | varchar(30)  | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
2 rows in set (0.01 sec)
insert into users values('your_name', 'your_password');
mysql> select * from user;
+-----------+----------------+
| name      | password       |
+-----------+----------------+
| your_name | your_password  |
+-----------+----------------+
1 row in set (0.01 sec)
```

## Webserver
+ Place the `servletInvoke` folder in the `TOMCAT_ROOT/webapps/` directory.
+ Start the webserver by either doing `./startup.bat` in `TOMCAT_ROOT/bin/` or running the `tomcat.exe` in root directory.
+ Then to check if Tomcat is running, open any browser and do `localhost:8080` .
  - If it shows the Tomcat Successful page, then it's all good.
+ Now append the `servletInvoke` to `localhost:8080/` like `localhost:8080/servletInvoke` .
+ Now you're all done!

## Notes

+ It uses `servlet-api v5.0.1` that means, `javax.*` is deprecated and is replaced with `jakarta.*`. For more information refer [here](https://jakarta.ee/specifications/servlet/5.0/jakarta-servlet-spec-5.0.html#changes-since-jakarta-servlet-4-0)
+ Html pages are created using **Bootstrap** fetched via **CDN**. Therefore proper viewing of the pages as intented by the developer is only possible if you have a proper internet connection.
