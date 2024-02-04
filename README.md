#Spring App Full with Docker

[//]: # (1. Project Deployment)

mvn install -DskipTests=true

[//]: # (2. Docker commands)

docker build -t java_api_crud .

docker-compose up --build

docker-compose down

docker-compose down -v -> Deletes running containers

[//]: # (3. View PostgresQL Data)

docker exec -it postgresql psql -U postgres -> Postgres Section

CREATE DATABASE java_db_crud;

[//]: # (There're 2 ways to switch to your db)

1. \c java_db_crud

2. docker exec -it postgresql psql -U postgres java_db_crud

\l -> All Available database

\dt -> All Available tables

\d student -> View table

SELECT * FROM student;
