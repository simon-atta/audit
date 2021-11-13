# Audit

This Repo is used to log audit for any data operation accross the system. i.e. Entity Country have been change by user X at this time.

This Repo will be mainly used to track admin / back office users operations.

1. Microservice will publish event for CREATE, UPDATE, DELETE of any entity. aduit-common has all model, mapper need to be used by microserice

2. In case of RabbitMQ is down microservice will save event to database, audit-common has all code need to be used, you just need to enable @EnableFailedAuditHandler in the application starter.

3. audit-service has schudler which will read from failed events database and convert to the main database.


![https://github.com/simon-atta/audit/blob/386a072ed7e1b02e825f728a0c72c08c47db24bf/Audit.png](https://github.com/simon-atta/audit/blob/386a072ed7e1b02e825f728a0c72c08c47db24bf/Audit.png)

## Technologies

* Language: java
* Core framework: Spring Boot 2 with Spring Framework 5
* Web framework: Spring MVC
* Persistence : MongoDB Data JPA
* Databases: MongoDB , MySql , TestContainers
* Build: Gradle Script
* Testing: Junit 5, Mockito
* Messaging: Rabbit MQ

## Running site configuration locally

### Docker

You can use this docker compose https://github.com/simon-atta/docker-compose/tree/master/rabbitmq to start rabbitmq instance.

### Kubernetes/Openshit

You can use helm chart https://github.com/simon-atta/helm/tree/master/rabbitmq

### With gradle command line

```
git clone https://github.com/simon-atta/audit
cd audit-service
./gradlew bootRun
```



You can then access site configuration here: [http://localhost:8080/]()
