package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EmployeeService {

	/**
	 * Returns a list containing only the Employee object. This method is not
	 * recommended to be called directly due to the unknown amount of data.
	 * 
	 * @return a list containing only the Employee object.
	 */
	public List<Employee> retrieveEmployees();

	/**
	 * Returns a Page object including a list of the Employee object and the
	 * pagination info.
	 * 
	 * @param pageIndex default 1 and start from 1.
	 * @param pageSize  default 20
	 * @return a Page object including a list of the Employee object and the
	 *         pagination info.
	 */
	public Page<Employee> getEmployeesByPage(Integer pageIndex, Integer pageSize);

	/**
	 * Searches the Employee object using the employeeId. Returns null if the
	 * employee does not exist.
	 * 
	 * @param employeeId the key to be searched for.
	 * @return a Employee object or null if the employee does not exist.
	 */
	public Employee getEmployeeById(Long employeeId);

	/**
	 * Saves a new Employee object to the database.
	 * 
	 * @param employee object
	 * @return a saved Employee object
	 */
	public Employee saveEmployee(Employee employee);

	/**
	 * Deletes a Employee object from the database.
	 * 
	 * @param employeeId
	 */
	public void deleteEmployee(Long employeeId);

	/**
	 * Updates a Employee object to the database.
	 * 
	 * @param employeeId
	 * @param employee
	 */
	public Employee updateEmployee(Long employeeId, Employee employee);
}