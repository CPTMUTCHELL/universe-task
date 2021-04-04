# universe-task

Recommendations:
1. Default port is 8080. In order to select another add server.port="desired port" in application.yml
2. Go to downloaded project folder, open cmd, run:
```
mvn clean package
``` 
3.After packaging run:
```
java -jar target/universe-task-0.0.1-SNAPSHOT.jar
```
4. Proceed to http://localhost:8080/start URL.
5. Proceed to http://localhost:8080/h2-console to open H2 console.
