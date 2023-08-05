# community-sensor-server
This is the **server side** portion of our Community Sensor project. For **client side**, see [here](https://github.com/GrayOrion/EnviroSensor).
This portion of our project is focused on data repository and interaction with persisted data. 
Data will flow to this repository from sensor platforms through a pub/sub system, to decouple the systems. 
In the future, we will also have a web interface for data visualization and management.

## Data Storage and Handling
So far we created 3 ways of managing our data:
1. In memory, Collection repository (List<Sensor> practically) for initial prototyping
2. JDBC repository for light abstraction of data management (using dockerized postgres or H2 in memory DB)
3. Spring Data JPA repository for full abstraction of data management (we will test dockerized postgres, but many RDBMS are supported)

These different data storage methods could be controlled through configuration profiles (TBD - might support only one type of data source and then will leave others as examples rather than options).

* See .pom file and .properties files and schema.sql file for commented out dependencies and configurations for all data source options


## Roadmap
* [X] Create a basic Spring Boot project
* [X] Create a basic REST controller
* [X] Create a basic Sensor model
* [X] Create a basic in memory repository
* [X] Create a basic Dockerfile
* [X] Create a basic JDBC repository
* [X] Create a basic Spring Data JPA repository
* [X] Create profiles to be able to differentiate dev/testing/production configurations
* [X] Add containerized deployment configuration
* [ ] Collect data from sub/pub system
* [ ] Create a basic web interface
* [ ] Deploy minimal system in cloud
* [ ] add a basic user management system
* [ ] add a sensor management system
* [ ] add a mapping system for sensors
* [ ] add a data visualization system

## Spring Boot Components/Frameworks

Spring Boot Actuator - production ready endpionts such as metrics, monitoring, and audit


## Deployment
Can be deployed through:
1. Jar 
   ./mvnw clean package
2. Docker - Cloud Native Buildpacks - OCI image
   ./mvnw spring-boot:build-image
      
