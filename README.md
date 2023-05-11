# BE_Automation_Example
This project is oriented in automatization of backed tests. It is using Rest Assured framework and TestNG.This project is a backend testing automation framework built using TestNG, RestAssured, Wire Mock, Lombok. 

It is designed to show project structure, code style and organization of the tests. 
Due to this purpose, it is not testing the actual application, but sending requests to created mock server.
Different mock servers will be built in test executing runtime and if TestNG listener find the annotation for special mock server,
it will be build (This can be found in configuration folder).
Also, this project is not focused on showing the large number of tests, but more project setup, objects, data organization etc.

## Prerequisites

Before running the tests, make sure you have the following prerequisites installed on your system:

- Java Development Kit (JDK) 17 or higher
- Maven (for dependency management)

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository to your local machine:


2. Navigate to the project directory


3. Install project dependencies using Maven.

4. Run the tests (The tests can be run from the editor, and from command line by: navigating to project folder, running command: mvn clean test.)

## Features

The backend testing automation framework offers the following features:

- TestNG: A powerful testing framework for creating and managing test cases.
- RestAssured: A Java library for simplified REST API testing.
- MockServer: A library for mocking and stubbing HTTP/S requests and responses.
- Lombok: A library that helps reduce boilerplate code by generating getters, setters, and other code automatically.
- Test Listener: Custom test listener to capture test results, generate reports, and perform additional actions.
- Data Provider: A data-driven approach using TestNG's DataProvider feature for parameterized testing.
