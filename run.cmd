mvn clean install -s ../settings.xml

docker build -t g1_gc_web -f src/main/resources/docker/g1_gc/Dockerfile .

docker run -p 8080:8080 --name g1_gc_web --rm g1_gc_web

docker build -t zgc_gc_web -f src/main/resources/docker/zgc_gc/Dockerfile .

docker run -p 9090:8080 --name zgc_gc_web --rm zgc_gc_web



# to stop
docker stop g1_gc_web

docker stop zgc_gc_web
# to remove
docker rm g1_gc_web

docker rm zgc_gc_web

# docker compose
docker-compose up -d --remove-orphans

docker-compose down