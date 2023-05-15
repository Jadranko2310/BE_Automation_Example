package pojo.logIn;

import data.user.LogInUserDetails;
import lombok.Getter;
import lombok.Setter;

/**
 * Log in request body.
 */

@Getter
@Setter
public class LogInRequestBody {

  private String userName;

  private String password;

  public LogInRequestBody() {

  }

  public LogInRequestBody(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public LogInRequestBody(LogInDescription description) {
    this.setLogInBodyBasedOnDescription(description);
  }

  /**
   * Setting username and password based on provided Enum description.
   */
  public void setLogInBodyBasedOnDescription(LogInDescription description) {
    switch (description) {
      case VALID -> {
        setUserName(LogInUserDetails.VALID_USERNAME);
        setPassword(LogInUserDetails.VALID_PASSWORD);
      }
      case INVALID -> {
        setUserName(LogInUserDetails.VALID_USERNAME);
        setPassword(LogInUserDetails.INVALLID_PASSWORD);
      }
      case MAVEN_PROPERTY -> {
        setUserName(System.getProperty("username"));
        setPassword(System.getProperty("password"));
      }
      default -> System.out.println("Body description not match, please entry parameter");
    }
  }
}
