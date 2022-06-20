FROM openjdk:18-alpine

COPY target/gc.comparison-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-XX:+UseZGC","-jar","/app.jar"]