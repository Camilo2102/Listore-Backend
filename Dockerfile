#
# Build stage
#
FROM maven:3-amazoncorretto-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17-alpine
COPY target/*.jar app.jar
# ENV PORT=8080
EXPOSE 7879
ENTRYPOINT ["java","-jar","demo.jar"]