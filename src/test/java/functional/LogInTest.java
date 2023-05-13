package functional;

import data.response.ExpectingStatusLine;
import data.user.LogInUserDetails;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import request.LogInRequest;
import setup.base.BaseTest;
import setup.mockserver.LogInServer;
import setup.mockserver.TestListener;

@Listeners(TestListener.class)
public class LogInTest extends BaseTest {

  LogInRequest userAction = new LogInRequest();


  @LogInServer
  @Test
  public void validLogIn() {
    response = userAction.logIn(LogInUserDetails.VALID_USERNAME,
            LogInUserDetails.VALID_PASSWORD);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(response.statusLine(), ExpectingStatusLine.SUCESS_LOG_IN);
    softAssert.assertTrue(response.time() < 3000,
            "Response time is longer than 3 sec");
    softAssert.assertAll("These are the issues: ");
  }
}
