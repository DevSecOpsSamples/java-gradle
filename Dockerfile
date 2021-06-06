FROM openjdk:8-jdk-alpine

RUN mkdir -p /opt/build 
ADD ./ /opt/build
WORKDIR /opt/build

RUN pwd \
    && ls \
    && ./gradlew build

VOLUME /tmp
ARG JAR_FILE=./build/libs/devopssample-java-gradle-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]