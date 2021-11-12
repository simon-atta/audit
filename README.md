# Audit service

![img.png](img.png)

## Technologies

* Language: java
* Core framework: Spring Boot 2 with Spring Framework 5
* Web framework: Spring MVC
* Persistence : MongoDB Data JPA
* Databases: MongoDB , TestContainers
* Build: Gradle Script with the Kotlin DSL
* Testing: Junit 5, Mockito and AssertJ
* Messaging: rabbit MQ

## Running site configuration locally

### With gradle command line

```
git clone https://github.com/AVICSS/audit-service.git
cd audit-service
./gradlew bootRun
```

### With Docker

```
docker run -p 8080:8080 avicss/audit-service
```

You can then access site configuration here: [http://localhost:8080/]()
