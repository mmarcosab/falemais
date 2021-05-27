from openjdk:12-alpine
COPY ./target/falemais-0.0.1-SNAPSHOT.jar /app/falemais-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "falemais-0.0.1-SNAPSHOT.jar"]