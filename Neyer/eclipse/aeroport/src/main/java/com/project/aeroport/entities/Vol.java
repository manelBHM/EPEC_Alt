package com.project.aeroport.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vol implements Serializable{
	@Id
	private String id;
	
	private String heurArriv;
	private String heurDepart;
	private String pilote;
	private String avion;
	private String siteDepart;
	private String siteArriv;
	

	public Vol() {
		super();
	}
	
	public Vol(String id, String heurArriv, String heurDepart, String pilote, String avion, String siteDepart,
			String siteArriv) {
		super();
		this.id = id;
		this.heurArriv = heurArriv;
		this.heurDepart = heurDepart;
		this.pilote = pilote;
		this.avion = avion;
		this.siteDepart = siteDepart;
		this.siteArriv = siteArriv;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAvion() {
		return avion;
	}
	public void setAvion(String avion) {
		this.avion = avion;
	}
	public String getHeurArriv() {
		return heurArriv;
	}
	public void setHeurArriv(String heurArriv) {
		this.heurArriv = heurArriv;
	}
	public String getHeurDepart() {
		return heurDepart;
	}
	public void setHeurDepart(String heurDepart) {
		this.heurDepart = heurDepart;
	}

	public String getPilote() {
		return pilote;
	}
	public void setPilote(String pilote) {
		this.pilote = pilote;
	}
	public String getSiteDepart() {
		return siteDepart;
	}
	public void setSiteDepart(String siteDepart) {
		this.siteDepart = siteDepart;
	}
	public String getSiteArriv() {
		return siteArriv;
	}
	public void setSiteArriv(String siteArriv) {
		this.siteArriv = siteArriv;
	}
		
}