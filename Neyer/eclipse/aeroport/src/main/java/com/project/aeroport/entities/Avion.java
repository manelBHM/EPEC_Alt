package com.project.aeroport.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity

public class Avion implements Serializable{
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nom")
	private String nomAvion;
	private String model;
	private int capacite;
	private String site;
	
	public Avion() {
		super();
	}
	
	public Avion(String nomAvion, String model, int capacite, String site) {
		super();
		this.nomAvion = nomAvion;
		this.model = model;
		this.capacite = capacite;
		this.site = site;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNomAvion() {
		return nomAvion;
	}

	public void setNomAvion(String nomAvion) {
		this.nomAvion = nomAvion;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}

}