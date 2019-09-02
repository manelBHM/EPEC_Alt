package com.spring.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="personnes")
public class Personne {
@Id @GeneratedValue
private Integer num;
private String nom;
private String prenom;

public Personne() {
	super();
	// TODO Auto-generated constructor stub
}

public Personne(Integer num, String nom, String prenom) {
	super();
	this.num = num;
	this.nom = nom;
	this.prenom = prenom;
}

public Integer getNum() {
return num;
}
public void setNum(Integer num) {
this.num = num;
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
}
