package com.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cours {

	
	//@GeneratedValue
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	//@ManyToOne(targetEntity = Professeur.class,fetch = FetchType.EAGER)
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="prof_id")
	@JsonIgnoreProperties("cours")
	Professeur professeur;
	private int nbHeurs;


	public Cours() {
		super();
	}


	public Cours(Long id, String libelle, Professeur professeur, int nbHeurs) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.professeur = professeur;
		this.nbHeurs = nbHeurs;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}


	public int getNbHeurs() {
		return nbHeurs;
	}
	public void setNbHeurs(int nbHeurs) {
		this.nbHeurs = nbHeurs;
	}
}
