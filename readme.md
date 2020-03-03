# Create image from dockerfile
docker build -t <App-name or custom name> .
docker build -t <App-name or custom name> -f="path-of-file"

# Run the application
docker run -p 8090:8080 <image-name>

first port for operating system. (in post man, we have to use this port)
second port for application running


# Create image new image previous image in docker file
docker-compose up --build

# Show running containers
docker ps

# Interact with running container
docker exec -it <image-id> bash
docker exec -it <image-id> /bin/sh

# Killing container
docker rm practise-app_app_1

# For Logs
docker-compose logs --tail=100 -f 

# Docker stats
docker stats

# Volume information
docker volume ls | grep <volume-name>
docker volume inspect <vigrant-name>


https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis.repositories.mapping

redis-cli --cluster create <pod-0-ip>:<port> ... <pod-5-ip>:<port> --cluster-replicas 1

https://www.youtube.com/watch?v=chIlHFwODvM
https://www.digitalocean.com/community/tutorials/how-to-configure-a-redis-cluster-on-ubuntu-14-04

https://spring.io/blog/2013/05/23/spring-framework-4-0-m1-websocket-support/
https://tyrus-project.github.io/documentation/1.13.1/index/websocket-api.html