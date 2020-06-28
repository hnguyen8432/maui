FROM openjdk:8u201-alpine3.9
MAINTAINER solers.com
ADD target/sample-app-1.0.jar /opt/spring-boot/lib/
ENTRYPOINT /usr/bin/java $JAVA_OPTS -jar /opt/spring-boot/lib/sample-app-1.0.jar
VOLUME /tmp