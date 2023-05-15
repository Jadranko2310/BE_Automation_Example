package data.provider;

import data.response.ExpectingStatusLine;
import data.user.LogInUserDetails;
import org.testng.annotations.DataProvider;
import pojo.logIn.LogInRequestBody;
import setup.base.BaseTest;
import setup.base.Constants;

/**
 * Data provider will iterate objects of LogIn Request Body
 * with invalid or incorrect data and expected status line.
 */

public class LogInInvalidData extends BaseTest {

  /**
   * Data provider method.
   */
  @DataProvider(name = "LogIn_invalid_data")
  public Object[][] logInData() {
    return new Object[][]{
            {
            new LogInRequestBody(
                    "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                            LogInUserDetails.VALID_PASSWORD),
            new ExpectingStatusLine(Constants.USERNAME_TOO_LONG)
            },
            {
            new LogInRequestBody("", LogInUserDetails.VALID_PASSWORD),
            new ExpectingStatusLine(Constants.EMPTY_FIELD)
            },
            {
            new LogInRequestBody(LogInUserDetails.VALID_USERNAME, ""),
            new ExpectingStatusLine(Constants.MISSING_PASSWORD)
            },
            {
            new LogInRequestBody(LogInUserDetails.VALID_USERNAME,
                    LogInUserDetails.INVALLID_PASSWORD),
            new ExpectingStatusLine(Constants.INCORRECT_CREDENTIALS)
            }
    };
  }
}
