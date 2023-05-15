package helpers;
import io.restassured.response.Response;
import setup.base.BaseTest;

/**
 * Asserting standard, expected responses.
 */
public class CustomAssert extends BaseTest {


  /**
   * Will assert standard response with status code 200
   * and response expected to be under 3 seconds as per industry standard.
   */
  public void validateStandardResponse(Response response, String statusLine) {
    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(response.statusLine(), statusLine);
    softAssert.assertTrue(response.time() < 3000);
    softAssert.assertAll("These are the issues: ");
  }
}
