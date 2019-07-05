package org.openup.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avions")
public class Avions {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id ;

@Column(name="constructeur")
private String constructeur;

@Column(name= "modele")
private String modele;

@Column(name="capacite")
private int capacite;

@Column(name="sitee")
private String sitee;

public Avions() {
	super();
	// TODO Auto-generated constructor stub
}

public Avions(long id, String constructeur, String modele, int capacite, String sitee) {
	super();
	this.id = id;
	this.constructeur = constructeur;
	this.modele = modele;
	this.capacite = capacite;
	this.sitee = sitee;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getConstructeur() {
	return constructeur;
}

public void setConstructeur(String constructeur) {
	this.constructeur = constructeur;
}

public String getModele() {
	return modele;
}

public void setModele(String modele) {
	this.modele = modele;
}

public int getCapacite() {
	return capacite;
}

public void setCapacite(int capacite) {
	this.capacite = capacite;
}

public String getSitee() {
	return sitee;
}

public void setSitee(String sitee) {
	this.sitee = sitee;
}

@Override
public String toString() {
	return "Avions [id=" + id + ", constructeur=" + constructeur + ", modele=" + modele + ", capacite=" + capacite
			+ ", sitee=" + sitee + "]";
} 



}
