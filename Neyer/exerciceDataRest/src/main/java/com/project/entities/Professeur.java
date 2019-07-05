package com.project.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Professeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String telephone;
	private int numero_Identite;
	private String email;
	private int niveau;
	
	//@OneToMany(mappedBy="professeur",fetch=FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL,mappedBy="professeur",fetch=FetchType.EAGER)
	@JsonIgnoreProperties("professeur")
	private List<Cours> cours;

	public Professeur(Long id, String nom, String prenom, String telephone, int numeroIdentite, String email,
			int niveau, List<Cours> cours) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.numero_Identite = numeroIdentite;
		this.email = email;
		this.niveau = niveau;
		this.cours = cours;
	}

	public Professeur() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getNumeroIdentite() {
		return numero_Identite;
	}

	public void setNumeroIdentite(int numeroIdentite) {
		this.numero_Identite = numeroIdentite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

}
