FROM openjdk:21
COPY build/libs/trainee-challenge-0.0.1-SNAPSHOT.jar trainee-challenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/trainee-challenge-0.0.1-SNAPSHOT.jar"]
