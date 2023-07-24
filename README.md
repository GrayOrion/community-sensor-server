# community-sensor-server
This is the **server side** portion of our Community Sensor project. For **client side**, see [here](https://github.com/GrayOrion/EnviroSensor).
This portion of our project is focused on data repository and interaction with persisted data. 
Data will flow to this repository from sensor platforms through a pub/sub system, to decouple the systems. 
In the future, we will also have a web interface for data visualization and management.

## Data Storage and Handling
So far we created 2 ways of managing our data:
1. In memory, Collection repository (List<Sensor> practically) for initial prototyping
2. JDBC repository for light abstraction of data management (using dockerized postgres or H2 in memory DB)
3. Spring Data JPA repository for full abstraction of data management (we will test dockerized postgres, but many RDBMS are supported)

## Roadmap
* [x] Create a basic Spring Boot project
* [x] Create a basic REST controller
* [x] Create a basic Sensor model
* [x] Create a basic in memory repository
* [x] Create a basic Dockerfile
* [x] Create a basic JDBC repository
* [x] Create a basic Spring Data JPA repository
* [ ] Collect data from sub/pub system
* [ ] Create a basic web interface
* [ ] Deploy minimal system in cloud
* [ ] add a basic user management system
* [ ] add a sensor management system
* [ ] add a mapping system for sensors
* [ ] add a data visualization system