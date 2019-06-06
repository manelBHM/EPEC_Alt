package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Integer id;
	private String name;
	private String dep;
	private Integer salary;
	
	public User() {
		super();
	}
	public User(Integer id, String name, String dep, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
