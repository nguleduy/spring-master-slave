FROM gradle:jdk21-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build --no-daemon

FROM eclipse-temurin:21-jdk-alpine
RUN adduser -D -u 1001 -s /bin/sh spring-master-slave \
  && mkdir /app \
  && chown spring-master-slave: /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-master-slave.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-master-slave.jar"]