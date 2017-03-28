FROM java:8

EXPOSE 8080
EXPOSE 9200
EXPOSE 9300

VOLUME /tmp
ADD profile-0.0.1.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]