FROM openjdk:21
COPY build/libs/trainee-challenge-0.0.1-SNAPSHOT.jar app/trainee-challenge-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app/trainee-challenge-0.0.1-SNAPSHOT.jar"]
