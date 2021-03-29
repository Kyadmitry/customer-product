FROM gradle:jdk15 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM adoptopenjdk:12.0.1_12-jdk-openj9-0.14.1

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/

ENTRYPOINT ["java", "-jar", "/app/customer_project-0.0.1-SNAPSHOT.jar"]