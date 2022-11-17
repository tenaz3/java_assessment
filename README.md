
### Notes:

- I decide to not cover 100% of test, I added test for you to have a notion what is possible to do it with integration and unit tests.
- I decide to not implement 100% CRUD actions, I tried to keep simple and follow the minimal requirements with responsibility separation.
- I also decide to not map all relations between the tables using JPA, only the necessary for the features.
- I added data.sql to be load always for purpose test.

## Generate jar:
```bash
 mvn install
```

## Build docker project

````bash
 docker build -t quiz-api-docker.jar .
````

## Start project

````bash
 docker-compose up 
# OR
 java -jar target/quiz-api-docker.jar
````

## Discussion points

- Migration tool like Flyway and Liquibase.
- Persistence in memory or dedicated db and JPA decoupling code.
- Caching
- Pagination on API
- Reactive API: Project Reactor and Spring WebFlux