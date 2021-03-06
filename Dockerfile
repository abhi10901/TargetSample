##

# Pull base image.
FROM ubuntu:14.04

ENV ES_PKG_NAME elasticsearch-2.4.4

# Install system level packages needed to install elastic search or dependancies.
RUN apt-get update && apt-get upgrade -y && apt-get -y install software-properties-common

# Install Java.
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 \
    select true | debconf-set-selections && \
    add-apt-repository -y ppa:webupd8team/java && \
    apt-get update && \
    apt-get install -y oracle-java8-installer && \
    rm -rf /var/lib/apt/lists/* && \
    rm -rf /var/cache/oracle-jdk8-installer

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# Install Elasticsearch.
RUN \
    cd / && \
    wget https://download.elasticsearch.org/elasticsearch/elasticsearch/$ES_PKG_NAME.tar.gz && \
    tar xvzf $ES_PKG_NAME.tar.gz && \
    rm -f $ES_PKG_NAME.tar.gz && \
    mv /$ES_PKG_NAME /elasticsearch

# Expose ports.
#   - 9200: HTTP
#   - 9300: transport
EXPOSE 9200
EXPOSE 9300

VOLUME /tmp
ADD profile-0.0.1.jar app.jar
RUN bash -c 'touch /app.jar'

ADD start.sh /start.sh
RUN chmod +x /start.sh
CMD ["/start.sh"]
