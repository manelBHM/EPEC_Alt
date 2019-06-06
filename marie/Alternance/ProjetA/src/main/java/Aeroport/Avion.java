package Aeroport;

import java.util.HashMap;

public class Avion {

	int id;
	String constructeur;
	String modele;
	double capacite;
	String site;
	
	HashMap<Avion, Integer> listeAvion= new HashMap<Avion, Integer>();
	
	public Avion(int id, String constructeur, String modele, double capacite, String site) {
		super();
		this.id = id;
		this.constructeur = constructeur;
		this.modele = modele;
		this.capacite = capacite;
		this.site = site;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getConstructeur() {
		return constructeur;
	}
	
	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}
	
	public String getModele() {
		return modele;
	}
	
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public double getCapacite() {
		return capacite;
	}
	
	public void setCapacite(double capacite) {
		this.capacite = capacite;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	@Override
	public String toString() {
		return "Avion [id=" + id + ", constructeur=" + constructeur + ", modele=" + modele + ", capacite=" + capacite
				+ ", site=" + site + "]";
	}
	
	
}
