package lucky.airport.application.entity;

import javax.persistence.*;

@Entity
@Table(name="vol")
public class Vol {
	
	private String site_depart, site_arrive, heure_depart, heure_arrivee;
	private long pilote_id, avion_id;
	private long id;
	
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public String getSite_depart() {
		return site_depart;
	}
	public void setSite_depart(String site_depart) {
		this.site_depart = site_depart;
	}
	public String getSite_arrive() {
		return site_arrive;
	}
	public void setSite_arrive(String site_arrive) {
		this.site_arrive = site_arrive;
	}
	public String getHeure_depart() {
		return heure_depart;
	}
	public void setHeure_depart(String heure_depart) {
		this.heure_depart = heure_depart;
	}
	public String getHeure_arrivee() {
		return heure_arrivee;
	}
	public void setHeure_arrivee(String heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}
	public long getPilote_id() {
		return pilote_id;
	}
	public void setPilote_id(long pilote_id) {
		this.pilote_id = pilote_id;
	}
	public long getAvion_id() {
		return avion_id;
	}
	public void setAvion_id(long avion_id) {
		this.avion_id = avion_id;
	}
	
}
