package functional;

import data.response.ExpectingStatusLine;
import data.user.LogInUserDetails;
import helpers.CustomAssert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import request.LogInRequest;
import setup.base.BaseTest;
import setup.mockserver.LogInServer;
import setup.mockserver.TestListener;

@Listeners(TestListener.class)
public class LogInTest extends BaseTest {

  LogInRequest userAction = new LogInRequest();

  CustomAssert customAssert = new CustomAssert();


  @LogInServer
  @Test
  public void validLogIn() {
    response = userAction.logIn(LogInUserDetails.VALID_USERNAME,
            LogInUserDetails.VALID_PASSWORD);

    customAssert.validatestandardresponse(response, ExpectingStatusLine.SUCESS_LOG_IN);
  }
}
