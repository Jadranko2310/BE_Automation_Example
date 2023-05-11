package setup.mockserver;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import data.request.logIn.LogInValidationData;
import lombok.Getter;
import lombok.Setter;
import setup.base.BaseApi;

/**
 * Mock Server for Log In service.
 */
@Getter
@Setter
public class LogInMockServer implements ImockServer {

  private WireMockServer server = new WireMockServer(8080);

  private BaseApi baseApi;

  public LogInValidationData data = new LogInValidationData();


  private void setup() {

    server.stubFor(post(urlEqualTo("/LogIn"))
            .withRequestBody(equalToJson(data.validLogInRequest))
            .willReturn(aResponse().withHeader("Content-Type", "application/json")
                    .withStatus(200)
                    .withStatusMessage("Welcome")));

    server.stubFor(post(urlEqualTo("/LogIn"))
            .withRequestBody(equalToJson(data.longUserName))
            .willReturn(aResponse().withHeader("Content-Type", "application/json")
                    .withStatus(405)
                    .withStatusMessage("The username can not be longer than 10 characters")));

    server.stubFor(post(urlEqualTo("/LogIn"))
            .withRequestBody(equalToJson(data.emptyUserName))
            .willReturn(aResponse().withHeader("Content-Type", "application/json")
                    .withStatus(405)
                    .withStatusMessage("The username can not be empty")));

    server.stubFor(post(urlEqualTo("/LogIn"))
            .withRequestBody(equalToJson(data.emptyPassword))
            .willReturn(aResponse().withHeader("Content-Type", "application/json")
                    .withStatus(405)
                    .withStatusMessage("The password is missing")));

    server.stubFor(post(urlEqualTo("/LogIn"))
            .withRequestBody(equalToJson(data.incorrectPassword))
            .willReturn(aResponse().withHeader("Content-Type", "application/json")
                    .withStatus(405)
                    .withStatusMessage("Incorrect password or username")));

  }

  @Override
  public void start() {
    setup();
    server.start();
  }

  @Override
  public void tearDown() {
    server.stop();
    server.shutdownServer();
  }
}