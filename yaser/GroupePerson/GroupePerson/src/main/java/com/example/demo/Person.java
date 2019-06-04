package com.example.demo;

public class Person {
	String id;
	String nom;
	String preNom;
	String dateNaissance;
	String marie;
	String nbEnfants;
	String version;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(String id, String nom, String preNom, String dateNaissance, String marie, String nbEnfants,
			String version) {
		super();
		this.id = id;
		this.nom = nom;
		this.preNom = preNom;
		this.dateNaissance = dateNaissance;
		this.marie = marie;
		this.nbEnfants = nbEnfants;
		this.version = version;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPreNom() {
		return preNom;
	}


	public void setPreNom(String preNom) {
		this.preNom = preNom;
	}


	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getMarie() {
		return marie;
	}


	public void setMarie(String marie) {
		this.marie = marie;
	}


	public String getNbEnfants() {
		return nbEnfants;
	}


	public void setNbEnfants(String nbEnfants) {
		this.nbEnfants = nbEnfants;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public void addPerson() {
		
	}
	public void updatePerson() {
		
	}
	public void deletPerson() {
		
	}
}
