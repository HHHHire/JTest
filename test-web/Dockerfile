FROM adoptopenjdk/openjdk8:latest
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","/app.jar"]
