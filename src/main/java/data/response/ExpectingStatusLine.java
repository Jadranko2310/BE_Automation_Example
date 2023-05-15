package data.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Response message constants.
 */
@Getter
@Setter
public class ExpectingStatusLine {

  private String message;

  public ExpectingStatusLine(String message) {
    this.message = message;
  }
}
