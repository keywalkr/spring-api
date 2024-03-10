FROM openjdk:17-jdk

WORKDIR /app

COPY kapi-server/target/kapi-server-0.0.1-SNAPSHOT.jar /app/kuma-spring-api.jar

EXPOSE 8080

CMD ["java",  "-jar", "kuma-spring-api.jar"]