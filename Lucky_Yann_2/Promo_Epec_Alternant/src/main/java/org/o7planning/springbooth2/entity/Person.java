package org.o7planning.springbooth2.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="alternant")
public class Person {
	
	private String firstname,lastname,entreprise,actif;

	@Id
	@GeneratedValue
	@Column(name = "Id", nullable = false)
	private Integer id;
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}


	public String getActif() {
		return actif;
	}


	public void setActif(String actif) {
		this.actif = actif;
	}


	
}
