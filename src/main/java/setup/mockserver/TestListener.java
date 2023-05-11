package setup.mockserver;

import lombok.SneakyThrows;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Test listener will check every test method before execution and proceed action
 * based on condition defined (is annotation present and is mock server
 * already running).
 */

public class TestListener implements ITestListener {

  TestListenerService server = new TestListenerService();

  @SneakyThrows
  @Override
  public void onTestStart(ITestResult result) {
    server.start(result);
  }

  @SneakyThrows
  @Override
  public void onTestSuccess(ITestResult result) {
    server.stop(result);
  }

  @SneakyThrows
  @Override
  public void onTestFailure(ITestResult result) {
    server.stop(result);
  }

  @SneakyThrows
  @Override
  public void onTestSkipped(ITestResult result) {
    server.stop(result);
  }

  @SneakyThrows
  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    server.stop(result);
  }

  @SneakyThrows
  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    server.stop(result);
  }
}
