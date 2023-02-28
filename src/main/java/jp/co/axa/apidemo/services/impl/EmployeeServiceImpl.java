package jp.co.axa.apidemo.services.impl;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.services.EmployeeService;
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

	@Deprecated
	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	/**
	 * {@inheritDoc}
	 */
	public Page<Employee> getEmployeesByPage(Integer pageIndex, Integer pageSize) {
		if (pageIndex == null || pageIndex < 1) {
			pageIndex = Const.DEFAULT_PAGE_INDEX;
		}

		if (pageSize == null || pageSize < 1) {
			pageSize = Const.DEFAULT_PAGE_SIZE;
		}
		// The first index of Pageable is 0,our pageIndex parameter is start from 1
		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
		Page<Employee> employees = employeeRepository.findAll(pageable);
		return employees;
	}

	/**
	 * {@inheritDoc} The object will be cached if the return value is not null.
	 */
	@Cacheable(cacheNames = "emp", key = "#employeeId", unless = "#result == null")
	public Employee getEmployeeById(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		// the get() will throw NoSuchElementException if no value is present
		return optEmp.get();
	}

	/**
	 * {@inheritDoc} The new object will be cached.
	 */
	@CachePut(cacheNames = "emp", key = "#result.id")
	public Employee saveEmployee(Employee employee) {
		Employee newEmployee = employeeRepository.save(employee);
		return newEmployee;
	}

	/**
	 * {@inheritDoc} This method will invalidate the cache.
	 */
	@CacheEvict(cacheNames = "emp", key = "#employeeId")
	public void deleteEmployee(Long employeeId) {
		if (employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
		} else {
			throw new NoSuchElementException("The employeeId does not exist");
		}

	}

	/**
	 * {@inheritDoc} This method will invalidate the cache.
	 */
	@CacheEvict(cacheNames = "emp", key = "#employeeId")
	public Employee updateEmployee(Long employeeId, Employee employee) {
		if (employeeRepository.existsById(employeeId)) {
			// TODO Normally ID is not allowed to be modified, we need to confirm
			// employee.id == employeeId.
			return employeeRepository.save(employee);
		} else {
			throw new NoSuchElementException("The employeeId does not exist");
		}
	}
}