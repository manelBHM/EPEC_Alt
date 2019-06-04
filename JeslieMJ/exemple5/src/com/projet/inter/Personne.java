package com.projet.inter;

import java.util.Date;
public class Personne {

	
	private String nom;
	private Date dateNais;
	private double salaire;
	public profil profil ;
	
	
	 public profil getProfil() {
		return profil;
	}

	public void setProfil(profil profil) {
		this.profil = profil;
	}

	 

	 
	 
	 
    
    
	      
    
 public Personne(String nom, Date dateNais, int salaire, profil profil) {
		// TODO Auto-generated constructor stub
	 this.nom =nom;
		this.dateNais = dateNais;
		this.salaire = salaire;   
		this.profil=profil;
	
	}

public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	
	

	 double calculerSalaire() {
		 
	//double code;
	if( profil.getLibelle().equals("DIR")) 
		salaire = (this.salaire*0.1) + this.salaire;
		
	 
		else if(profil.getLibelle().equals("DIR"))
		  salaire = (this.salaire*0.2)+ this.salaire;
		 return salaire;}
	 
public void  affiche() {
      System.out.println("Je m'appelle " + this.nom+". Je suis né le "+this.dateNais+". Mon salaire est de "+  calculerSalaire());
	 
}
}
