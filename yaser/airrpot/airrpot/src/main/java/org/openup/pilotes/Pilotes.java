package org.openup.pilotes;

public class Pilotes {
	
	int id;
	String nom;
	String sit;
	public Pilotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pilotes(int id, String nom, String sit) {
		super();
		this.id = id;
		this.nom = nom;
		this.sit = sit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSit() {
		return sit;
	}
	public void setSit(String sit) {
		this.sit = sit;
	}
	@Override
	public String toString() {
		return "Pilotes [id=" + id + ", nom=" + nom + ", sit=" + sit + "]";
	}
	

}
