package pojo.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDefinition {
  private String seniority;
  private boolean automation;
  private String language;
  private boolean testDocumentation;
  private int workHoursPerWeek;
}
