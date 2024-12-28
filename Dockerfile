FROM gradle:jdk17 AS builder

WORKDIR /workspace
COPY build.gradle settings.gradle ./
RUN gradle dependencies --no-daemon
COPY . .
RUN gradle bootJar --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /workspace/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]