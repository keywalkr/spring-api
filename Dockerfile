FROM openjdk:17-jdk-alpine
MAINTAINER qburry.com

WORKDIR /app

COPY kapi-server/target/kapi-server-0.0.1-SNAPSHOT.jar /app/kuma-spring-api.jar

EXPOSE 8080

ENTRYPOINT ["java",  "-jar", "kuma-spring-api.jar"]