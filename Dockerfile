FROM gradle:8.2.1-jdk17 AS build

COPY . /streaming-web-service

WORKDIR /streaming-web-service

RUN gradle clean build

FROM openjdk:17

COPY --from=build /streaming-web-service/build/libs/streaming-service-0.0.1-SNAPSHOT.jar /app/streaming-web-service.jar

WORKDIR /app

CMD ["java", "-jar", "streaming-web-service.jar"]