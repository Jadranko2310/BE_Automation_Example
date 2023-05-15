package functional;

import data.response.ExpectingStatusLine;
import data.user.LogInUserDetails;
import helpers.CustomAssert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.logIn.LogInDescription;
import pojo.logIn.LogInRequestBody;
import request.LogInRequest;
import setup.base.BaseTest;
import setup.base.Constants;
import setup.mockserver.LogInServer;
import setup.mockserver.TestListener;

@Listeners(TestListener.class)
public class LogInTest extends BaseTest {

  LogInRequest userAction = new LogInRequest();

  CustomAssert customAssert = new CustomAssert();


  /**
   * This test will ask for username and password
   * on terminal during Maven runtime.
   * After this, it will validate the response.
   */
  @LogInServer
  @Test
  public void validLogIn() {
    LogInRequestBody requestBody = new LogInRequestBody(LogInDescription.MAVEN_PROPERTY);
    response = userAction.logIn(requestBody.getUserName(), requestBody.getPassword());

    customAssert.validateStandardResponse(response, Constants.SUCESS_LOG_IN);
  }
}
