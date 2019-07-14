package com.simplon.DVD.produit;

import java.util.HashMap;


public class Produit {
	
	String nom;
	String description;
	double prix;
	HashMap<Produit, Integer> listProd = new HashMap<Produit, Integer>();
	
	public Produit(String nom, String description, int quantite, double prix) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public HashMap<Produit, Integer> getListProd() {
		return listProd;
	}

	public void setListProd(HashMap<Produit, Integer> listProd) {
		this.listProd = listProd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String toString() {
		return "Vous avez choisis : " + this.nom + " à " + this.prix + " Euros unitÃ©.";
	}
	
}
