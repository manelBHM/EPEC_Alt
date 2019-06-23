package com.springBoot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	private Long id;
	private String role;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Role(Long id, String role) {
		super();
		this.id=id;;
		this.role = role;
	}


	public String getRole() {
		return this.role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id=id;
	}
	
	

}
