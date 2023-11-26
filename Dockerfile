FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY https://github.com/Olinirina/socket.git
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
