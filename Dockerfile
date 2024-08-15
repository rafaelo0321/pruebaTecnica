FROM openjdk:21-jdk
COPY target/pruebaTecnica-0.0.1-SNAPSHOT.jar java-app.jar
EXPOSE 8090
ENTRYPOINT sh -c "java -jar java-app.jar"