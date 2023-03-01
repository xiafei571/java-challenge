package jp.co.axa.apidemo.services.request;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("employee")
public class EmployeeRequest {
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

}
