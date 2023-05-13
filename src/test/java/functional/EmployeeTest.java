package functional;

import data.response.ExpectingStatusLine;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.employee.Employee;
import pojo.employee.UserDescription;
import setup.base.BaseApi;
import setup.base.Endpoints;
import setup.mockserver.EmployeeServer;
import setup.mockserver.TestListener;


@Listeners(TestListener.class)
public class EmployeeTest extends BaseApi {

  @EmployeeServer
  @Test
  public void getSingleEmployee(){
    response = request.get(Endpoints.EMPLOYEE);
    Employee employeeBody = response.as(Employee.class);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(employeeBody.getDirectManager(),  ExpectingStatusLine.REGULAR_EMPLOYEE_TEST);
    softAssert.assertTrue(response.time() < 3000,
            "The response time is not under 3 seconds");
    softAssert.assertAll("These are the issues: ");
  }

  @EmployeeServer
  @Test
  public void createNewEmployee() throws Exception {
    request.body(new Employee(UserDescription.REGULAR));
    response = request.post(Endpoints.NEW_EMPLOYEE);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(response.statusLine(), ExpectingStatusLine.NEW_USER_CREATED);
    softAssert.assertTrue(response.time() < 3000,
            "The response time is not under 3 seconds");
    softAssert.assertAll("These are the issues: ");
  }
}
