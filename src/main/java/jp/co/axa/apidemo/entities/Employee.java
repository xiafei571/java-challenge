package jp.co.axa.apidemo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jp.co.axa.apidemo.services.request.EmployeeRequest;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column(name = "EMPLOYEE_NAME")
	private String name;

	@Getter
	@Setter
	@Column(name = "EMPLOYEE_SALARY")
	private Integer salary;

	@Getter
	@Setter
	@Column(name = "DEPARTMENT")
	private String department;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

	public Employee(EmployeeRequest employeeRequest) {
		this.name = employeeRequest.getName();
		this.salary = employeeRequest.getSalary();
		this.department = employeeRequest.getDepartment();
	}

}
