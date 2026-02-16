package org.springframework.samples.petclinic.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.springframework.samples.petclinic.model.Person;

@Entity
@Table(name = "users")
public class User extends Person {

	@Column(unique = true)
	@NotBlank
	private String username;

	@Column
	@NotBlank
	private String role;

	@Column
	@NotBlank
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
