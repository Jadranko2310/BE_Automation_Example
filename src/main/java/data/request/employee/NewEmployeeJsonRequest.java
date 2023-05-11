package data.request.employee;

/**
 * Mock data, will be used for building mock response request or response bodies.
 */
public class NewEmployeeJsonRequest {

  public String newEmployeeJsonRequest = """
          {
            "id" : 22,
            "name":  "John",
            "lastName": "Doe",
            "position": "DEVOPS",
            "jobDefinition": {
              "seniority": "mediator",
              "automation": true,
              "language": "JMeter",
              "testDocumentation": true,
              "workHoursPerWeek": 40
            },
            "directManager": "Petar Petrovic"
          }""";
}
