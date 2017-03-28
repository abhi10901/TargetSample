FROM java:8

VOLUME /tmp

ADD elasticsearch /elasticsearch
ENTRYPOINT ["/elasticsearch/bin/elasticsearch"]

ADD profile-0.0.1.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]