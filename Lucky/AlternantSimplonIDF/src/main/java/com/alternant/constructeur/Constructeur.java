package com.alternant.constructeur;

import java.util.*;

public class Constructeur {

	private String nom,prenom,entreprise,annee;
	private static int nmbreAlternant;
	private boolean actif;
	
	public Constructeur(String nom, String prenom, String entreprise, String annee, boolean actif)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.entreprise = entreprise;
		this.annee = annee;
		this.actif = actif;
		nmbreAlternant++;
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

	public static int getNmbreAlternant() {
		return nmbreAlternant;
	}

	public static void setNmbreAlternant(int nmbreAlternant) {
		Constructeur.nmbreAlternant = nmbreAlternant;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public List<Constructeur> addStagiaire(Constructeur a, ArrayList<Constructeur> listAlternant)
	{
		listAlternant.add(a);
		
		return listAlternant;
	}
}
