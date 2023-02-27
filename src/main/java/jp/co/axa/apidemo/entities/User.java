package jp.co.axa.apidemo.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER")
public class User {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column(name = "USER_NAME", nullable = false)
	private String username;

	@Getter
	@Setter
	@Column(name = "USER_PASSWORD", nullable = false)
	private String password;

	@Getter
	@Setter
	@Column(name = "ACTIVE")
	private int active;

	@Getter
	@Setter
	@Column(name = "ROLES")
	private String roles = "";

	@Getter
	@Setter
	@Column(name = "PERMISSIONS")
	private String permissions = "";

	public User(String username, String password, String roles, String permissions) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
		this.active = 1;
	}

	protected User() {
	}

	public List<String> getRoleList() {
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}

	public List<String> getPermissionList() {
		if (this.permissions.length() > 0) {
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}

}
