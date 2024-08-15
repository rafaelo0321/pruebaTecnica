FROM openjdk:21-jdk
COPY target/pruebaTecnica-0.0.1-SNAPSHOT.jar java-app.jar

ENTRYPOINT sh -c "java -jar java-app.jar"