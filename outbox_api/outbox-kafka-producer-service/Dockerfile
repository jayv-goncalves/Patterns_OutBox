FROM openjdk:17-slim
WORKDIR /src
COPY target/outbox-kafka-producer-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
