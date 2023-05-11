package pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

/**
 * Expected response body from Server after sending bad request.
 */
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BadRequestBody {

  private String message;

  private int errorCode;

  public BadRequestBody() {
  }

  public BadRequestBody(String message, int errorCode) {
    this.message = message;
    this.errorCode = errorCode;
  }


  public BadRequestBody(String requestIssue) throws Exception {
    this.changeBodyBasedOnBodyIssue(requestIssue);
  }

  /**
  * Based on body description parameter it will change the response body.
  */

  public void changeBodyBasedOnBodyIssue(String bodyDescription) throws Exception {
    switch (bodyDescription) {
      case "Method" -> {
        setMessage("Method not allowed. Use GET method only.");
        setErrorCode(405);
      }
      case "Header" -> setMessage("Content not allowed");
      default -> throw new Exception("Error body description");
    }
  }
}