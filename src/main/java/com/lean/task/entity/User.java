package com.lean.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//user table
@Entity(name="Role")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String role;
	
	//NoArgs Constructor
	public User() {
		super();
	}
	
	//AllArgs Constructor
	public User(Long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
