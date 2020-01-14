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
