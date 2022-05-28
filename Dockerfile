FROM openjdk:11

COPY ./target/javaexample-0.0.1-SNAPSHOT.war /app.war

ENTRYPOINT ["java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=0.0.0.0:9898", "/app.war"]