package negative;

import data.provider.LogInInvalidData;
import data.response.ExpectingStatusLine;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.logIn.LogInRequestBody;
import request.LogInRequest;
import setup.base.BaseTest;
import setup.mockserver.LogInServer;
import setup.mockserver.TestListener;

@Listeners(TestListener.class)
public class LogInTest extends BaseTest {

  LogInRequest userAction = new LogInRequest();

  @LogInServer
  @Test(dataProvider = "LogIn_invalid_data", dataProviderClass = LogInInvalidData.class)
  public void checkingLogInValidations(LogInRequestBody requestBody,
                                       ExpectingStatusLine statusLine) {
    response = userAction.logIn(requestBody.getUserName(), requestBody.getPassword());

    softAssert.assertEquals(response.statusCode(), 405);
    softAssert.assertEquals(response.statusLine(), statusLine.getMessage());
    softAssert.assertTrue(response.time() < 3000,
            "response time longer than 3000");
    softAssert.assertAll("These are the issues: ");
  }
}
