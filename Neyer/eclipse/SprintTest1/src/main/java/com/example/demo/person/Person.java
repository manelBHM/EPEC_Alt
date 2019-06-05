package com.example.demo.person;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity    //il va chercher dans la base de donnée si une tab s'appelle "Person" 
public class Person implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="NOM", length=30)
	@NotEmpty
	@Size(min=3,max=20,message="plus de 3 carateres")
	private String nom;
	@NotEmpty
	@Size(min=3,max=20)
	private String prenom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	private int conteur;
	//private byte[] photo;// stocker la photo dans la bese de donnée
	private String photo;//stocker nom photo la photo est stocke dans un dossier

	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String nom, String prenom, Date dateNaissance, int conteur, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.conteur = conteur;
		this.photo = photo;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getConteur() {
		return conteur;
	}

	public void setConteur(int conteur) {
		this.conteur = conteur;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}