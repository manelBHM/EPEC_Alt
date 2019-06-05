package org.openup.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vols")
public class Vols {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
@Column(name="avion")	
private int avion;

@Column(name="pilote")
private int pilote;

@Column(name="siteArrivee")
private String siteArrivee;

@Column(name="siteDepart")
private String siteDepart;

@Column(name = "heureArrivee")
private String heureArrivee;

@Column(name="heureDepart")
private String heureDepart;

public Vols() {
	super();
	// TODO Auto-generated constructor stub
}

public Vols(long id, int avion, int pilote, String siteArrivee, String siteDepart, String heureArrivee,
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

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public int getAvion() {
	return avion;
}

public void setAvion(int avion) {
	this.avion = avion;
}

public int getPilote() {
	return pilote;
}

public void setPilote(int pilote) {
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

@Override
public String toString() {
	return "Vols [id=" + id + ", avion=" + avion + ", pilote=" + pilote + ", siteArrivee=" + siteArrivee
			+ ", siteDepart=" + siteDepart + ", heureArrivee=" + heureArrivee + ", heureDepart=" + heureDepart + "]";
}


}
