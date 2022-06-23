FROM openjdk:18-alpine

COPY target/gc.comparison-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-Xmx512m", "-Xms512m", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9500", "-Dcom.sun.management.jmxremote.rmi.port=9500", "-Dcom.sun.management.jmxremote.authenticate=false", "-Dcom.sun.management.jmxremote.local.only=false", "-Dcom.sun.management.jmxremote.ssl=false", "-XX:+UseZGC", "-jar", "/app.jar"]