FROM java:8-jdk-alpine

COPY ./target/practise-app-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch practise-app-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=dev", "practise-app-0.0.1-SNAPSHOT.jar"]