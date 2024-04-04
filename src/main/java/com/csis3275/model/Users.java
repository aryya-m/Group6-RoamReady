package com.csis3275.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a user in the system.
 * 
 * This entity is mapped to a "users" table in the database, where each row represents a user.
 * Each user has an id, username, password, and email.
 */
@Entity
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String username;

private String password;

private String email;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
