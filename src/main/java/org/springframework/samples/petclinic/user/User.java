package org.springframework.samples.petclinic.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.samples.petclinic.model.Person;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Person {

	@Column(unique = true)
	@NotBlank
	private String username;

	@Column
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;

	@Column
	@NotBlank
	@Size(min = 8, message = "Password must be at least 8 characters long")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$",
			message = "Password must contain at least one uppercase letter, one lowercase letter, and one number")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
