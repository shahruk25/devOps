FROM openjdk:8
COPY ./target/devops-0.0.1-SNAPSHOT.jar devops-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","devops-0.0.1-SNAPSHOT.jar"]