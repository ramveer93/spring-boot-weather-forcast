FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} weather-springboot-app.jar
ENTRYPOINT ["java","-jar","/weather-springboot-app.jar"]