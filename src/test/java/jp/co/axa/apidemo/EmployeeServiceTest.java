package jp.co.axa.apidemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.services.request.EmployeeRequest;
import jp.co.axa.apidemo.util.Const;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiDemoApplication.class)
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;

	private EmployeeRequest employeeRequest;

	@Before
	public void setup() {
		employeeRequest = new EmployeeRequest();
		employeeRequest.setDepartment("Testing");
		employeeRequest.setName("Test name");
		employeeRequest.setSalary(9999);
	}

	/**
	 * JUnit test for saveEmployee method
	 */
	@Test
	public void whenSaveEmployee_thenReturnEmployeeObject() {
		// when - action or the behaviour that we are going test
		Employee savedEmployee = employeeService.saveEmployee(employeeRequest);

		System.out.println(savedEmployee);
		// then - verify the output
		assertThat(savedEmployee).isNotNull();
	}

	/**
	 * JUnit test for getEmployeesByPage method
	 */
	@Test
	public void whenGetEmployeesByPage_thenReturnEmployeesList() {

		// when - action or the behaviour that we are going test
		Page<Employee> employeePage = employeeService.getEmployeesByPage(Const.DEFAULT_PAGE_INDEX,
				Const.DEFAULT_PAGE_SIZE);

		// then - verify the output
		assertThat(employeePage).isNotNull();
		assertThat(employeePage.getTotalElements()).isEqualTo(2);
	}

	/**
	 * JUnit test for getEmployeeById method
	 */
	@Test
	public void whenGetEmployeeById_thenReturnEmployeeObject() {
		Long employeeId = 1L;
		// when - action or the behaviour that we are going test
		Employee savedEmployee = employeeService.getEmployeeById(employeeId);

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
	}

	/**
	 * JUnit test for updateEmployee method
	 */
	@Test
	public void whenUpdateEmployee_thenReturnUpdatedEmployee() {
		// save the object
		Employee savedEmployee = employeeService.saveEmployee(employeeRequest);

		String NEW_DEPARTMENT = "New Department";
		String NEW_NAME = "New Name";
		Integer NEW_SALARY = 10000;

		employeeRequest.setDepartment(NEW_DEPARTMENT);
		employeeRequest.setName(NEW_NAME);
		employeeRequest.setSalary(NEW_SALARY);

		// when - action or the behaviour that we are going test
		Employee updatedEmployee = employeeService.updateEmployee(savedEmployee.getId(), employeeRequest);

		// then - verify the output
		assertThat(updatedEmployee.getDepartment()).isEqualTo(NEW_DEPARTMENT);
		assertThat(updatedEmployee.getName()).isEqualTo(NEW_NAME);
		assertThat(updatedEmployee.getSalary()).isEqualTo(NEW_SALARY);
	}

	/**
	 * JUnit test for deleteEmployee method
	 */
	@Test
	public void whenDeleteEmployee_thenNothing() {
		Employee savedEmployee = employeeService.saveEmployee(employeeRequest);
		// when - action or the behaviour that we are going test
		employeeService.deleteEmployee(savedEmployee.getId());
		// then - verify the output
		try {
			employeeService.getEmployeeById(savedEmployee.getId());
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

	}

}
