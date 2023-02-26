package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.util.Const;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	public Page<Employee> retrieveEmployees(Integer pageIndex, Integer pageSize) {
		if (pageIndex == null || pageIndex < 1) {
			pageIndex = Const.DEFAULT_PAGE_INDEX;
		}

		if (pageSize == null || pageSize < 1) {
			pageSize = Const.DEFAULT_PAGE_SIZE;
		}

		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
		Page<Employee> employees = employeeRepository.findAll(pageable);
		return employees;
	}

	@Cacheable(cacheNames = "emp", key = "#employeeId", unless = "#result == null")
	public Employee getEmployee(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		return optEmp.get();
	}

	@CachePut(cacheNames = "emp", key = "#result.id")
	public Employee saveEmployee(Employee employee) {
		Employee newEmployee = employeeRepository.save(employee);
		return newEmployee;
	}

	@CacheEvict(cacheNames = "emp", key = "#employeeId")
	public void deleteEmployee(Long employeeId) {
		if (employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
		} else {
			throw new NoSuchElementException("The employeeId does not exist");
		}

	}

	@CacheEvict(cacheNames = "emp", key = "#employeeId")
	public void updateEmployee(Long employeeId, Employee employee) {
		if (employeeRepository.existsById(employeeId)) {
			//TODO Normally ID is not allowed to be modified, we need to confirm employee.id == employeeId.
			employeeRepository.save(employee);
		} else {
			throw new NoSuchElementException("The employeeId does not exist");
		}
	}
}