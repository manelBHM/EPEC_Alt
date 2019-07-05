package com.booking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// 
public class Pilote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name")
	private String name;
	
	
	@Column(name = "site")
	private String site;
	
	
	public Pilote() {
		super();
	}

	public Pilote(long id) {
		this.id = id;

	}
	


	public Pilote(long id, String name, String site) {
		super();
		this.id = id;
		this.name = name;
		this.site = site;

	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Pilote [id=" + id + ", name=" + name +  ", site=" + site ;
	}


	

}
