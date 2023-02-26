package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EmployeeService {

    public List<Employee> retrieveEmployees();
    
    public Page<Employee> retrieveEmployees(Integer pageIndex, Integer pageSize);

    public Employee getEmployee(Long employeeId);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Long employeeId);

    public void updateEmployee(Employee employee);
}