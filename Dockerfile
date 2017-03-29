FROM ubuntu:15.04

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean
	
RUN wget https://download.elastic.co/elasticsearch/elasticsearch/elasticsearch-2.4.4.deb
RUN dpkg -i elasticsearch-2.4.4.deb
RUN update-rc.d elasticsearch defaults
ENTRYPOINT ["service", "elasticsearch", "start"]

#install Spring Boot artifact
VOLUME /tmp
ADD profile-0.0.1.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]