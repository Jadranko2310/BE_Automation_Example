package helpers;
import io.restassured.response.Response;
import setup.base.BaseTest;

public class CustomAssert extends BaseTest {

  public void validatestandardresponse(Response response, String statusLine) {
    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(response.statusLine(), statusLine);
    softAssert.assertEquals(response.statusLine(), statusLine);
    softAssert.assertTrue(response.time() < 3000);
    softAssert.assertAll("These are the issues: ");
  }
}
