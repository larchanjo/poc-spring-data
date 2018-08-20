# Overview

This is a simple poc using [spring-data]

## Testing

* `docker run --name poc-mysql -e MYSQL_ROOT_PASSWORD=123456 -d -p 3306:3306 mysql:5.7`
* `docker exec -it poc-mysql bash`
* `mysql -u root -p 123456`
* `create database db_example`
* `exit`
* `mvn spring-boot:run`

[spring-data]: http://projects.spring.io/spring-data/