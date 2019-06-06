FROM java:8
VOLUME /tmp
ADD avion.jar app.jar
EXPOSE 8081
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]