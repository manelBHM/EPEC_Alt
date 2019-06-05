package org.openup.entities;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.crypto.Data;

@Entity         // it important to add it
public class Etudeant implements Serializable{
  @Id                                 // it important to add it
  @GeneratedValue                  // it important to add it
	private long id;
	private String nom;
	private Date datenissance;
	private String email;
	private String photo;
	public Etudeant() {            // this for JPA and for me
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudeant(String nom, Date datenissance, String email, String photo) {   // this for me
		super();
		this.nom = nom;
		this.datenissance =  datenissance;
		this.email = email;
		this.photo = photo;
	}
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
	public Date getDatenissance() {
		return datenissance;
	}
	public void setDatenissance(Date datenissance) {
		this.datenissance = datenissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
