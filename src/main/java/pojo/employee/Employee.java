package pojo.employee;

import lombok.Getter;
import lombok.Setter;

/**
 * Employee body. Can be used as request and response body.
 */
@Getter
@Setter
public class Employee {
  private int id;
  private String name;
  private String lastName;
  private String position;

  private JobDefinition jobDefinition;

  private String directManager;

  public Employee() {}

  /**
   * Employee constructor.
   */
  public Employee(int id, String name, String lastName, String position,
                  JobDefinition jobDefinition, String directManager) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.position = position;
    this.jobDefinition = jobDefinition;
    this.directManager = directManager;
  }

  public Employee(UserDescription description) throws Exception {
    this.setBodyBasedOnDescription(description);
  }

  /**
   * Setting the employee body based on Enum parameter provided.
   */
  public void setBodyBasedOnDescription(UserDescription description) throws Exception {
    switch (description) {
      case REGULAR -> {
        setId(22);
        setName("John");
        setLastName("Doe");
        setPosition("DEVOPS");
        JobDefinition jobDefinition1 = new JobDefinition();
        jobDefinition1.setSeniority("mediator");
        jobDefinition1.setAutomation(true);
        jobDefinition1.setLanguage("JMeter");
        jobDefinition1.setTestDocumentation(true);
        jobDefinition1.setWorkHoursPerWeek(40);
        setJobDefinition(jobDefinition1);
        setDirectManager("Petar Petrovic");
      }

      case NON_EXISTING -> {
        setId(88);
        setName("Elton");
        setLastName("John");
        setPosition("Backed Developer");
        jobDefinition.setSeniority("senior");
        jobDefinition.setAutomation(true);
        jobDefinition.setLanguage("C++");
        jobDefinition.setTestDocumentation(true);
        jobDefinition.setWorkHoursPerWeek(40);
        setJobDefinition(jobDefinition);
        setDirectManager("Johnny Cash");
      }

      default -> System.out.println("Body description not match, please entry parameter");
    }
  }
}
