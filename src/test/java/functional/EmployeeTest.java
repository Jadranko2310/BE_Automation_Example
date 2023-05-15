package functional;

import helpers.CustomAssert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.employee.Employee;
import pojo.employee.UserDescription;
import setup.base.BaseTest;
import setup.base.Constants;
import setup.mockserver.EmployeeServer;
import setup.mockserver.TestListener;


@Listeners(TestListener.class)
public class EmployeeTest extends BaseTest {

  CustomAssert customAssert = new CustomAssert();

  @EmployeeServer
  @Test
  public void getSingleEmployee(){
    response = request.get(Constants.EMPLOYEE);
    Employee employeeBody = response.as(Employee.class);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(employeeBody.getDirectManager(), Constants.REGULAR_EMPLOYEE_TEST);
    softAssert.assertTrue(response.time() < 3000,
            "The response time is not under 3 seconds");
    softAssert.assertAll("These are the issues: ");
  }

  @EmployeeServer
  @Test
  public void createNewEmployee() throws Exception {
    request.body(new Employee(UserDescription.REGULAR));
    response = request.post(Constants.NEW_EMPLOYEE);

    customAssert.validateStandardResponse(response, Constants.NEW_USER_CREATED);
  }
}
