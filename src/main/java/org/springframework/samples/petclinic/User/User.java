package org.springframework.samples.petclinic.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "enabled")
	private boolean enabled = true;

	// --- Helpers to check Authority Level ---

	// Level 1: Admin (Can do everything)
	public boolean isAdmin() {
		return "ADMIN".equals(this.role);
	}

	// Level 2: Receptionist (Can edit owners/pets/visits)
	public boolean isReceptionist() {
		return "RECEPTIONIST".equals(this.role) || "ADMIN".equals(this.role);
	}

	// Level 3: Standard User (Read Only)
	// Everyone is at least a user, so this is true for all active accounts
	public boolean isUser() {
		return true;
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
