package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.services.request.EmployeeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@ApiOperation(value = "Get the employee list by page", notes = "pageIndex start from 1, pageSize shoud be greater than 0")
	@GetMapping("/employees")
	public Page<Employee> getEmployees(@RequestParam(required = false) Integer pageIndex,
			@RequestParam(required = false) Integer pageSize) {
		Page<Employee> employees = employeeService.getEmployeesByPage(pageIndex, pageSize);
		return employees;
	}

	@ApiOperation(value = "Get the employee info by ID")
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@ApiOperation(value = "Add a new employee info")
	@PostMapping("/employees")
	public void saveEmployee(EmployeeRequest employee) {
		employeeService.saveEmployee(employee);
		//System.out.println("Employee Saved Successfully");
	}

	@ApiOperation(value = "Delete a employee info")
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		//System.out.println("Employee Deleted Successfully");
	}

	@ApiOperation(value = "Update a employee info")
	@PutMapping("/employees/{employeeId}")
	public void updateEmployee(@RequestBody EmployeeRequest employee, @PathVariable(name = "employeeId") Long employeeId) {
		employeeService.updateEmployee(employeeId, employee);
	}

}
