package lucky.airport.application.entity;

import javax.persistence.*;

@Entity
@Table(name="pilote")
public class Pilote {

	private String nom, site;
	private long id, matricule;
	
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getMatricule() {
		return matricule;
	}
	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "détails des vols prévus pour Monsieur : " + nom;
	}
	
	
}
