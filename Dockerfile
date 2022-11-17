FROM openjdk:11
ADD target/quiz-api-docker.jar quiz-api-docker.jar
ENTRYPOINT ["java", "-jar","quiz-api-docker.jar"]
EXPOSE 8080