FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]
