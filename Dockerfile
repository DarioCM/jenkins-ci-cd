FROM openjdk:24
LABEL authors="darko"
WORKDIR /appContainer
COPY ./target/jenkins-cicd.jar /appContainer
EXPOSE 8282
CMD ["java", "-jar", "jenkins-cicd.jar"]