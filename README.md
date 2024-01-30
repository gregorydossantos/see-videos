# SEE-VIDEOS
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gregorydossantos/projeto-sds3/blob/main/LICENSE)
<br/>This is a project from my graduate studies in Architecture and development at FIAP.

## About SEE-VIDEOS
This project consists of creating a rest API, using reactive programming (Spring WebFlux) and MongoDB as a database.
## Technologies:
- Java 17
- Spring-boot 3.1.0
- MongoDB 7.0.5
- Mongo-Express
- Docker

## Libraries:
- Lombok
- JUnit
- Mockito

#### Notes:
To create the database and upload it locally, first confirm that you have docker installed on your machine, after that follow these steps:
<br/> - cd see-videos/docker
<br/> - sudo docker-compose up -d (to start database)
<br/> - sudo docker-compose down -d (to finish database)
### Endpoints (Swagger):
After running the project, we can access the API documentation through Swagger: <br/>
Link: http://localhost:8080/swagger-ui/index.html#/