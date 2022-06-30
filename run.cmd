mvn clean install -s ../settings.xml

#G1 web
docker build -t g1_gc_web -f src/main/resources/docker/g1_gc/Dockerfile .

docker run -p 8080:8080 --name g1-gc-web --rm g1_gc_web

#ZGC web
docker build -t zgc_gc_web -f src/main/resources/docker/zgc_gc/Dockerfile .

docker run -p 9090:8080 --name zgc-gc-web --rm zgc_gc_web

#G1 tester
docker build -t g1_tester -f src/main/resources/docker/shell_g1/Dockerfile .

docker run --name g1_tester --rm g1_tester

#ZGC tester
docker build -t zgc_tester -f src/main/resources/docker/shell_zgc/Dockerfile .

docker run --name zgc-tester --rm zgc_tester

# to stop
docker stop g1-gc-web

docker stop zgc-gc-web
# to remove
docker rm g1-gc-web

docker rm zgc-gc-web

# docker compose
docker-compose up -d --remove-orphans

docker-compose down