package setup.mockserver;

import java.lang.reflect.Method;
import org.testng.ITestResult;

/**
 * Defining conditions for starting and stopping the mock server.
 */

public class TestListenerService {

  EmployeeMockServer employeeMockServer = new EmployeeMockServer();

  LogInMockServer logInMockServer = new LogInMockServer();

  /**
   * Start server if annotation is present in test method.
   */
  public void start(ITestResult result) {
    Method trackedMethod = result.getMethod().getConstructorOrMethod().getMethod();

    if (trackedMethod.isAnnotationPresent(EmployeeServer.class)) {
      try {
        employeeMockServer.start();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    if (trackedMethod.isAnnotationPresent(LogInServer.class)) {
      try {
        logInMockServer.start();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * Stopping server if the annotation is present in test method.
   */
  public void stop(ITestResult result) {
    Method trackedMethod = result.getMethod().getConstructorOrMethod().getMethod();

    if (trackedMethod.isAnnotationPresent(EmployeeServer.class)
            && employeeMockServer.getServer().isRunning()) {
      employeeMockServer.tearDown();
    }

    if (trackedMethod.isAnnotationPresent(LogInServer.class)
            && logInMockServer.getServer().isRunning()) {
      employeeMockServer.tearDown();
    }
  }
}
