package setup.base;

import helpers.FileControlUtil;

/**
 * Endpoints and Status message constants
 */
public class Constants {

  public static final FileControlUtil fileControlEndpoints;

  static {
    try {
      fileControlEndpoints = new FileControlUtil(FileControlUtil.ENDPOINTS_DATA_PROPERTIES);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // ENDPOINTS //
  public static final String BASE_URI = fileControlEndpoints.getValue("BASE_URI");
  public static final String EMPLOYEE = "SingleEmployee";
  public static final String NEW_EMPLOYEE = "/newEmployee";
  public static final String LOG_IN = "/LogIn";

  // EXPECTING RESPONSE MESSAGE //
  public static final String NEW_USER_CREATED =
          "HTTP/1.1 200 The new user successfully  created";

  public static final String REGULAR_EMPLOYEE_TEST = "John Doe";

  public static final String SUCESS_LOG_IN = "HTTP/1.1 200 Welcome";

  public static final String USERNAME_TOO_LONG
          = "HTTP/1.1 405 The username can not be longer than 10 characters";

  public static final String EMPTY_FIELD = "HTTP/1.1 405 The username can not be empty";

  public static final String MISSING_PASSWORD = "HTTP/1.1 405 The password is missing";

  public static final String INCORRECT_CREDENTIALS = "HTTP/1.1 405 Incorrect password or username";
}
