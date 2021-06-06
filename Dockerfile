FROM openjdk:8-jdk-alpine

RUN mkdir -p /opt/build 
ADD ./ /opt/build
WORKDIR /opt/build

RUN pwd \
    && ls -alh \
    && ./gradlew build --no-daemon \
    && ls -alh ./build/libs/ \
    && cp ./build/libs/devopssample-java-gradle-0.0.1.jar app.jar

VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]