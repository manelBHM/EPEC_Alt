package org.openup.pilotes.avions;

public class Avions {
	
	int id;
	String constructeur;
	String modele;
	int capacite;
	String sitee;
	public Avions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avions(int id, String constructeur, String modele, int capacite, String sitee) {
		super();
		this.id = id;
		this.constructeur = constructeur;
		this.modele = modele;
		this.capacite = capacite;
		this.sitee = sitee;
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
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public String getSitee() {
		return sitee;
	}
	public void setSitee(String sitee) {
		this.sitee = sitee;
	}
	@Override
	public String toString() {
		return "Avions [id=" + id + ", constructeur=" + constructeur + ", modele=" + modele + ", capacite=" + capacite
				+ ", sitee=" + sitee + "]";
	}
	
	

}
