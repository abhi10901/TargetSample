#!/bin/bash

/elasticsearch/bin/elasticsearch -Des.insecure.allow.root=true -d
echo "elasticsearch started"

java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
echo "project start"
