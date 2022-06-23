FROM ubuntu:latest

RUN apt-get update && apt-get install -y curl && apt-get install -y vim && apt-get install -y bash

COPY src/main/resources/scripts/run_g1.sh /etc

RUN chmod +x /etc/run_g1.sh

ENTRYPOINT ["bash", "/etc/run_g1.sh"]