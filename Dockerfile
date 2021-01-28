FROM maven:3.6.3-openjdk-11 AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package

FROM openjdk:11-jre-slim
COPY --from=build /tmp/target/recruitment-task-project-0.0.1-SNAPSHOT.jar /usr/app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/recruitment-task-project-0.0.1-SNAPSHOT.jar"]