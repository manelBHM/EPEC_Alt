package Model;

import java.util.Date;

public class Personne {
	int Id;
	int version;
	String nom, prenom;
	Date date_naissance;
	boolean Marie;
	int nbr_enf;
	
	public Personne(int id, int version, String nom, String prenom, Date date_naissance, boolean marie, int nbr_enf) {
		super();
		Id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		Marie = marie;
		this.nbr_enf = nbr_enf;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
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
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public boolean isMarie() {
		return Marie;
	}
	public void setMarie(boolean marie) {
		Marie = marie;
	}
	public int getNbr_enf() {
		return nbr_enf;
	}
	public void setNbr_enf(int nbr_enf) {
		this.nbr_enf = nbr_enf;
	}
	
	
	

}
