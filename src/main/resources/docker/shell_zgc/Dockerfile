FROM ubuntu:latest

RUN apt-get update && apt-get install -y curl && apt-get install -y vim && apt-get install -y bash

COPY src/main/resources/scripts/run_zgc.sh /etc

RUN chmod +x /etc/run_zgc.sh

ENTRYPOINT ["bash", "/etc/run_zgc.sh"]