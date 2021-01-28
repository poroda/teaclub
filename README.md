# Teaclub app for training Java Spring Boot with PostGreSQL and running with docker

## Prerequisities

1. Clone or fork the repository
2. Open it in your favourite IDE
3. Install docker and docker-compose

## Tasks

Cinia Jyväskylä employees have ordered that they need HTTP endpoints (which return json), and a database to maintain their teas. Someone
has already created the following instructions to setup a database and a http-server to get the project running. Your
task now is to continue the project. The PO has created the following tasks to your backlog. Go ahead and select one
of them to start your project with. Note that the PO has not given thought to which items are dependent of another.
Follow the instructions of setup and complete one of the next story points. After completing, make a pull request and send
a notification to your reviewer.

- As a teaclub member I want to add a tea, so that I can maintain my data.
- As a teaclub member I want to add ingredients, so that I can view which ingredients are available.
- As a teaclub member I want to add amounts to ingredients (grams (g)), so that I can maintain our ingredient stock.
- As a teaclub member I want to get ingredients, so that I know which ingredients I have in stock.
- As a teaclub member I want to get teas which include a given ingredient, so that I can search for a tea I'd like to have.
- As a teaclub member I want to search teas by variety, so that I can search for tea I'd like to have now.

## Setup

### Running PostgreSQL and Flyway in Docker

To run PostgreSQL in Docker and apply schema using flyway, you have to run the following command 
(in the directory where docker-compose-postgres.yml file is located):
``docker-compose -f docker-compose-postgres.yml up``

This creates a running instance of postgresql database with migrations to generate some tables and data.
You can view the database container (such as it's name) by typing to another window:
``docker ps``

You can access the container and database inside it by typing:
``docker container exec -it name_of_your_container bash``
Then by typing:
``psql -h 0.0.0.0 -p 5432 -U teaclub-user -d teaclub``

Now you can view tables with normal postqresql commands.
You should be able to connect to the database in container by using database name, password and user data from 
docker-compose-postgresql.yml file

### Setup application configurations

Replace '172.21.0.1' with your ip in application.properties -file (/src/resources/application.properties)
The application is running in container and the database container exposes 
the port 5432 to your localhost, yet docker does not understand that 'localhost' would mean the host which runs the container.

Your local ip can be found e.g. by ```ifconfig -a```.

### Building and running the springboot application

Build with docker (see dependencies are installed)

``docker build -t tea-club-app .``

Run with docker

``docker run -p 8080:8080 -t tea-club-app``

To test your application is running correctly, ``curl http://localhost:8080/healthcheck`` should print ``your application is running``