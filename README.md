# worldofwords

## Overview
`worldofwords` is a small Spring Boot web application that provides a simple word game around categories such as animals, cities, countries and names (based on the hungarian "Ország-Város"(Country-City) game). The project is implemented in Java with Spring Boot and uses Maven for build and dependency management.

## The game
The game challenges players to supply words that belong to selected categories (Animals, Cities, Countries, Boy and Girl names). The server-side components (`model` and `repository`) hold category lists and a `GameController` exposes game interactions via the web UI or API.

## Prerequisites
- Java 17+ (or Java 11 if your environment requires it)
- Maven 3.6+
- IntelliJ IDEA (project tested in IntelliJ IDEA 2024.3.7)
- (Optional) Git

## Run locally

Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA.
2. Run the main class `hu.unideb.inf.worldofwords.WorldofwordsApplication` (right-click > Run).
3. Check one of the API endpoints: `http://localhost:8082/testCountries`, `http://localhost:8082/testCities`, `http://localhost:8082/testBoyNames`, `http://localhost:8082/testGirlNames`, `http://localhost:8082/testAnimals`.

Using Maven (Windows)
1. Open Command Prompt in the project root (`C:\dolgaim\worldofwords`).
2. Build and run:
   - To run directly: `mvn spring-boot:run`
   - To build a jar and run:
      - `mvn clean package`
      - ~~`java -jar target/worldofwords-0.0.1-SNAPSHOT.jar`~~ *doesn't work*


## Configuration
Application-level properties can be adjusted in:
- `src/main/resources/application.properties`

## Notes
- The web endpoints and UI are served by the controllers in `src/main/java/hu/unideb/inf/worldofwords/web`.
- If the application port or context path is customized, consult `application.properties`.