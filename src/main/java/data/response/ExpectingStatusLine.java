package data.response;

import helpers.FileControlUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Response message constants.
 */
@Getter
@Setter
public class ExpectingStatusLine {

  private String message;

  public ExpectingStatusLine(String message) {
    this.message = message;
  }

  public static final FileControlUtil fileControlResponseMessage;

  static {
    try {
      fileControlResponseMessage = new FileControlUtil(FileControlUtil.RESPONSE_MESSAGE);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static final String NEW_USER_CREATED = fileControlResponseMessage
          .getValue("NEW_USER_CREATED");

  public static final String REGULAR_EMPLOYEE_TEST = fileControlResponseMessage
          .getValue("REGULAR_EMPLOYEE_TEST");

  public static final String SUCESS_LOG_IN = "HTTP/1.1 200 Welcome";

  public static final String USERNAME_TOO_LONG
          = "HTTP/1.1 405 The username can not be longer than 10 characters";

  public static final String EMPTY_FIELD = "HTTP/1.1 405 The username can not be empty";

  public static final String MISSING_PASSWORD = "HTTP/1.1 405 The password is missing";

  public static final String INCORRECT_CREDENTIALS = "HTTP/1.1 405 Incorrect password or username";
}
