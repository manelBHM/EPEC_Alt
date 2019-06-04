package org.openup.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "pilotes")
public class Pilotes {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "nom")
private  String nom;

@Column(name = "sit")	
private String sit;

public Pilotes() {
	super();

}

public Pilotes(long id, String nom, String sit) {
	super();
	this.id = id;
	this.nom = nom;
	this.sit = sit;
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

public String getSit() {
	return sit;
}

public void setSit(String sit) {
	this.sit = sit;
}

@Override
public String toString() {
	return "Pilotes [id=" + id + ", nom=" + nom + ", sit=" + sit + "]";
}






	
	
}
