package data.provider;

import data.response.ExpectingStatusLine;
import data.user.LogInUserDetails;
import org.testng.annotations.DataProvider;
import pojo.logIn.LogInRequestBody;
import setup.base.BaseApi;

/**
 * Data provider will iterate objects of LogIn Request Body
 * with invalid or incorrect data and expected status line.
 */

public class LogInInvalidData extends BaseApi {

  /**
   * Data provider method.
   */
  @DataProvider(name = "LogIn invalid data")
  public Object[][] logInData() {
    return new Object[][]{
            {
            new LogInRequestBody(
                    "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                            LogInUserDetails.VALID_PASSWORD),
            new ExpectingStatusLine(ExpectingStatusLine.USERNAME_TOO_LONG)
            },
            {
            new LogInRequestBody("", LogInUserDetails.VALID_PASSWORD),
            new ExpectingStatusLine(ExpectingStatusLine.EMPTY_FIELD)
            },
            {
            new LogInRequestBody(LogInUserDetails.VALID_USERNAME, ""),
            new ExpectingStatusLine(ExpectingStatusLine.MISSING_PASSWORD)
            },
            {
            new LogInRequestBody(LogInUserDetails.VALID_USERNAME,
                    LogInUserDetails.INVALLID_PASSWORD),
            new ExpectingStatusLine(ExpectingStatusLine.INCORRECT_CREDENTIALS)
            }
    };
  }
}
