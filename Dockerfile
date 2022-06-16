FROM maven:3-jdk-8-alpine
RUN apk add ca-certificates
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/target/flighttracker-1.0.0-SNAPSHOT.jar"]
