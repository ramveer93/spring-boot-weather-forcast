FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} demo-boot-weather.jar
ENTRYPOINT ["java","-jar","/demo-boot-weather.jar"]