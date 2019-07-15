package com.dvdenligne.entity;

import javax.persistence.*;

@Entity
@Table(name = "langue")
public class Langue {

	@Id
	private long id;
	
	private String nom, last_update;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	
	
	
}
