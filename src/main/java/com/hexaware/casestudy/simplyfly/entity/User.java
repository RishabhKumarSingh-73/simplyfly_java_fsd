package com.hexaware.casestudy.simplyfly.entity;

import com.hexaware.casestudy.simplyfly.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String email;
	private String passwordHash;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean isActive;
	
	
	
	public int getId() {
		return id;
	}
	
	
	
	



	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User() {
		super();
	}

	public User(int id, String username, String email, String passwordHash, Role role, boolean isActive) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.role = role;
		this.isActive = isActive;
	}
	
	
}
