FROM openjdk:16-alpine3.13
COPY "api-0.0.1-SNAPSHOT.jar" "/app.jar"
EXPOSE 8080
ENV URLMongo="adicione o caminho do mongodb aqui"
CMD [ "-jar", "/app.jar" ]
ENTRYPOINT [ "java" ]