package data.user;

import helpers.FileControlUtil;

/**
 * User details needed for log in.
 */
public class LogInUserDetails {

  public static final FileControlUtil fileControlUser;

  static {
    try {
      fileControlUser = new FileControlUtil(FileControlUtil.USER_DATA_PROPERTIES);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  public static final String VALID_USERNAME = fileControlUser
          .getValue("USERNAME_REGULAR");

  public static final String VALID_PASSWORD = fileControlUser
          .getValue("PASSWORD_REGULAR");

  public static final String INVALLID_PASSWORD = fileControlUser
          .getValue("INCORRECT_PASSWORD");
}
