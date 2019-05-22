

# Sample REST CRUD API with Spring Boot, Mysql, JPA and Hibernate 

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/AlexKyriazis/Restex.git
```

**2. Create Mysql database**
```bash
create database restdb
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/spring-boot-rest-api-tutorial-0.0.1-SNAPSHOT.jar

```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

get all the reports 
```bash
http://localhost:8080/api/reports/all
```

get the reports based by username, priority and pagenumber
page size is 10 
```bash
http://localhost:8080/api/reports/userNamePriority/?username=DESIRABLE_USERNAME&priority=HIGH_OR_LOW&pageNumber=PAGE_NUMBER
```
