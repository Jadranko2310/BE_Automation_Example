package setup.mockserver;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import data.request.employee.NewEmployeeJsonRequest;
import lombok.Getter;
import lombok.Setter;
import setup.base.BaseApi;

/**
 * Mock server. Defined base configuration (response code, headers, response body)
 */

@Getter
@Setter
public class EmployeeMockServer implements ImockServer {

  private WireMockServer server = new WireMockServer(8000);

  private BaseApi baseApi;

  public NewEmployeeJsonRequest data = new NewEmployeeJsonRequest();

  public EmployeeMockServer() {

  }

  private void setup() {

    server.stubFor(get(urlEqualTo("/SingleEmployee"))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBodyFile("Mock.json")));
    //Single employee - invalid request
    server.stubFor(post(urlEqualTo("/SingleEmployee"))
            .willReturn(aResponse().withHeader("Content-Type", "application/json")
                    .withStatus(400)
                    .withBody("Bad request body")));
    //Adding the new employee
    server.stubFor(post(urlEqualTo("/newEmployee"))
            .withRequestBody(equalToJson(data.newEmployeeJsonRequest))
            .willReturn(aResponse().withHeader("Content-Type", "application/json")
                    .withStatus(200)
                    .withStatusMessage("The new user successfully  created")));
  }


  public void start() {
    setup();
    server.start();
  }


  public void tearDown() {
    server.stop();
    server.shutdownServer();
  }
}
