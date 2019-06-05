package Model;

public class Avion {
	
	int id;
	String constructeur, modele, capacite, site;
	
	
	
	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avion(int id, String constructeur, String modele, String capacite, String site) {
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
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	
	

}
