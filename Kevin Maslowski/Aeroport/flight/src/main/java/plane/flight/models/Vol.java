package plane.flight.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vol {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 32)
	private String id;
	private Integer avion;
	private Integer pilote;
	private String siteArrivee;
	private String siteDepart;
	private String heureArrivee;
	private String heureDepart;
	
	public Vol() {}

	public Vol(String id, Integer avion, Integer pilote, String siteArrivee, String siteDepart, String heureArrivee,
			String heureDepart) {
		super();
		this.id = id;
		this.avion = avion;
		this.pilote = pilote;
		this.siteArrivee = siteArrivee;
		this.siteDepart = siteDepart;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAvion() {
		return avion;
	}

	public void setAvion(Integer avion) {
		this.avion = avion;
	}

	public Integer getPilote() {
		return pilote;
	}

	public void setPilote(Integer pilote) {
		this.pilote = pilote;
	}

	public String getSiteArrivee() {
		return siteArrivee;
	}

	public void setSiteArrivee(String siteArrivee) {
		this.siteArrivee = siteArrivee;
	}

	public String getSiteDepart() {
		return siteDepart;
	}

	public void setSiteDepart(String siteDepart) {
		this.siteDepart = siteDepart;
	}

	public String getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	
	
	
}
