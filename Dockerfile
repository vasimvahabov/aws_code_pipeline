FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml /app
RUN mvn dependency:resolve

COPY . /app
RUN mvn clean
RUN mvn package -DskipTests -X

FROM eclipse-temurin:21-jdk
COPY --from=build app/target/*.jar app.jar

EXPOSE 8899
CMD [ "java", "-jar", "app.jar" ]
