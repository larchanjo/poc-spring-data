# Overview

This is a simple poc using [spring-data](http://projects.spring.io/spring-data)

## Pre Requirements

* Docker
* Docker Compose

## Setup

To start the application we need to stat the MySQL first, running the command below:

`docker-compose up -d`

Then, start the application, running the command below:

`mvn clean spring-boot:run`