package negative;

import data.provider.LogInInvalidData;
import data.response.ExpectingStatusLine;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.logIn.LogInRequestBody;
import request.LogInRequest;
import setup.base.BaseApi;
import setup.mockserver.LogInServer;
import setup.mockserver.TestListener;

@Listeners(TestListener.class)
public class LogInTest extends BaseApi {

  LogInRequest userAction = new LogInRequest();

  @LogInServer
  @Test(dataProvider = "LogIn invalid data", dataProviderClass = LogInInvalidData.class)
  public void checkingLogInValidations(LogInRequestBody requestBody,
                                       ExpectingStatusLine statusLine) {
    response = userAction.logIn(requestBody.getUserName(), requestBody.getPassword());

    Assert.assertEquals(response.statusCode(), 405);
    Assert.assertEquals(response.statusLine(), statusLine.getMessage());
    softAssert.assertTrue(response.time() < 3000,
            "response time longer than 3000");
    softAssert.assertAll("These are the issues: ");
  }
}
