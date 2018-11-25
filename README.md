# Technology tech choices

## Spring Boot
I chose Spring boot because I've used it to develop web APIs.
On retrospect I think Spring Integration would have been a better choice.

## MongoDB
This was the first time i've worked with a NoSQL database so chose MongoDB because it is supported by Spring Boot.

# How to run
* Start docker-compose to bring up the mongoDB and TCP server
* Run ./gradlew bootRun to start the application
* Run ./gradlew test to run unit test
* Run ./gradlew sonarqube to get test coverage
