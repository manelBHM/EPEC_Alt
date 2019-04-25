package org.o7planning.springbooth2.entity;

import java.util.*;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="alternant")
public class Person {

	private String nom,prenom,entreprise,annee,actif;
	private Integer id;


	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public String getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}


	public String getAnnee() {
		return annee;
	}


	public void setAnnee(String annee) {
		this.annee = annee;
	}


	public String getActif() {
		return actif;
	}


	public void setActif(String actif) {
		this.actif = actif;
	}
}
