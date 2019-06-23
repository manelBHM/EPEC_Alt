package com.springBoot.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
public class Vol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String noVol;
	@OneToOne
	private Avion avion;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date heureArrivee;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date heureDepart;
	@OneToOne
	private Pilote pilote;
	private String siteArrivee;
	private String siteDepart;
	
	private String site;
	
	
	
	
	public Vol(String noVol) {
		this.noVol = noVol;
	}
	public Vol(Long id, String noVol, Avion avion, Date heureArrivee, Date heureDepart, Pilote pilote, String siteArrivee,
			String siteDepart, String site) {
		super();
		this.id = id;
		this.noVol = noVol;
		this.avion = avion;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.pilote = pilote;
		this.siteArrivee = siteArrivee;
		this.siteDepart = siteDepart;
		this.site = site;
	}
	public Vol(String noVol, Avion avion, Pilote pilote, String site) {
		super();
		this.noVol = noVol;
		this.avion = avion;
		this.pilote = pilote;
		this.site = site;
	}
	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNoVol() {
		return noVol;
	}
	public void setNoVol(String noVol) {
		this.noVol = noVol;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public Date getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public Date getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Pilote getPilote() {
		return pilote;
	}
	public void setPilote(Pilote pilote) {
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	

}
