# TargetSample 

This is the sample project build using spring-boot and elasticsearch and exposed docker image to run quickly.
Project feature is about to store customer complains.
Basic Complains Structure is given below:

```

Id : Unique ComplaintId,
name: Complaint Summary,
averageRating: Rating about product 1-100,
category: Product Department (e.g Toys, Electronics)
owner: Customer Name
description: Full description of complaint.  
     
```   

## Installation

### Run 

1. `$ docker pull abhandari10901/spring-boot-elasticsearch:0.0.2`
2. `$ docker run -it -p 8080:8080 -p 9200:9200 -p 9300:9300 -e "http.host=0.0.0.0" -e "transport.host=127.0.0.1" abhandari10901/spring-boot-elasticsearch:0.0.2`

## Exposed APIs

### POST API URL to add Data: 

`http://localhost:8080/complaints/`
```
Header: Content-Type: application/json

Row Body:
{
    "name":"Consumer Complaints - 3",
    "averageRating":50,
    "category":"Government",
    "description":"The CFPB maintains historical data from the semi-annual survey of Credit Card Plans available from 1990.",
    "owner":"ming"
}
```

Hit SEND.

### GET API URL to retrieve all Data (Check if data is added or not):

`http://localhost:8080/complaints/`

Hit SEND.

### GET API URL to retrieve specific complaint by unique id (Filter Data by Id):

`http://localhost:8080/complaints/{id}`

Hit SEND.

### GET API URL to retrieve all complaint by unique category (Filter Data by category):

`http://localhost:8080/complaints/category/{category}`

Hit SEND.










 




