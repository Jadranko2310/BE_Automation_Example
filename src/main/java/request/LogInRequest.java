package request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.logIn.LogInRequestBody;
import setup.base.BaseTest;
import setup.base.Endpoints;

/**
 * Log in request definition.
 */
public class LogInRequest extends BaseTest {

  /**
   * Log in request.
   */
  public Response logIn(String username, String password) {
    request = RestAssured
            .given()
            .baseUri(Endpoints.BASE_URI)
            .port(8080)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();


    LogInRequestBody requestBody = new LogInRequestBody(username, password);
    request.body(requestBody);
    response = request.post(Endpoints.LOG_IN);
    return response;
  }
}
