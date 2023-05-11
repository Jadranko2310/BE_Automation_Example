package data.request.logIn;

/**
 * Mock data, will create log in request body
 * with too long name.
 */

public class LogInValidationData {

  public String validLogInRequest = """
          {
          "userName": "John Doe",
          "password": "Jhscd23$$$"
          }""";

  public String longUserName = """
          {
          "userName": "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
          "password": "Jhscd23$$$"
          }""";

  public String emptyUserName = """
          {
          "userName": "",
          "password": "Jhscd23$$$"
          }""";

  public String emptyPassword = """
          {
          "userName": "John Doe",
          "password": ""
          }""";

  public String incorrectPassword = """
          {
          "userName": "John Doe",
          "password": "pass123"
          }""";
}