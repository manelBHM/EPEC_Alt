package avions.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Vol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(length = 32)
	String id;
	@ManyToOne(targetEntity = Pilote.class)
	@JoinColumn(name="pilote_id")
	Pilote pilote;
	
	@ManyToOne(targetEntity = Avion.class)
	@JoinColumn(name="avion_id")
	Avion avion;
	String hdepart;
	String harrivee;
	String sitedepart;
	String sitearrivee;

	public Vol() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
     
	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}
    
	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public String getHdepart() {
		return hdepart;
	}

	public void setHdepart(String hdepart) {
		this.hdepart = hdepart;
	}

	public String getHarrivee() {
		return harrivee;
	}

	public void setHarrivee(String harrivee) {
		this.harrivee = harrivee;
	}

	public String getSitedepart() {
		return sitedepart;
	}

	public void setSitedepart(String sitedepart) {
		this.sitedepart = sitedepart;
	}

	public String getSitearrivee() {
		return sitearrivee;
	}

	public void setSitearrivee(String sitearrivee) {
		this.sitearrivee = sitearrivee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
