package lucky.airport.application.entity;

import javax.persistence.*;

@Entity
@Table(name="avion")
public class Avion {

	private String constructeur, modele, capacite, site;
	private long id;
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
