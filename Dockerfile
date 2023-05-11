FROM openjdk:17-alpine
WORKDIR / BE_Automation_Example
COPY pom.xml .
RUN mvn -B dependency:resolve
COPY src /BE_Automation_Example/src
RUN mvn clean install
CMD mvn clean test
