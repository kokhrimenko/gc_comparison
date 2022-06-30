FROM adoptopenjdk/openjdk11

RUN apt-get update && apt-get install -y curl && apt-get install -y vim

COPY target/gc.comparison-0.0.1-SNAPSHOT.jar app1.jar

ENTRYPOINT ["java", "-Xmx512m", "-Xms512m", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=8500", "-Dcom.sun.management.jmxremote.rmi.port=8500", "-Dcom.sun.management.jmxremote.authenticate=false", "-Dcom.sun.management.jmxremote.local.only=false", "-Dcom.sun.management.jmxremote.ssl=false", "-jar", "/app1.jar"]