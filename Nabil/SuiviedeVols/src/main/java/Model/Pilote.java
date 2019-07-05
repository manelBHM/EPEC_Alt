package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity



public class Pilote {
	
	@Id
	@GeneratedValue
	int ID;
	String nom;
	String site;
	
	public Pilote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pilote(int ID, String nom, String site) {
		super();
		this.ID = ID;
		this.nom = nom;
		this.site = site;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = ID;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	

}


