FROM openjdk:8-jre
COPY build/libs/babmeokeon-0.0.1-SNAPSHOT.jar babmeokeon.jar
ENTRYPOINT ["java", "-jar", "babmeokeon.jar"]