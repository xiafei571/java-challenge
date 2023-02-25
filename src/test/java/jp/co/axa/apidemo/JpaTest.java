package jp.co.axa.apidemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiDemoApplication.class)
public class JpaTest {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testFindAll() {
		List<Employee> all = employeeRepository.findAll();
		System.out.println("findAll:" + all);
	}

}
