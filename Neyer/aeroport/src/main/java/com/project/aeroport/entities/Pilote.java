package com.project.aeroport.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pilote implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPilote;
	
	private String nom;
	private String site;
	
	public Pilote() {
		super();
	}

	public Pilote(String nom, String site) {
		super();
		this.nom = nom;
		this.site = site;
	}

	

	public Long getIdPilote() {
		return idPilote;
	}

	public void setIdPilote(Long idPilote) {
		this.idPilote = idPilote;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
}