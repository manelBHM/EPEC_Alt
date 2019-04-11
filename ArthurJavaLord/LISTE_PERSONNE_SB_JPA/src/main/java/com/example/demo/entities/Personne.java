package com.example.demo.entities;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.bytebuddy.implementation.bind.annotation.Default;

@Entity
public class Personne implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="Prenom", length=32)
	private String prenom;
	@Column(name="Nom", length=32)
	private String nom;
	@Column(name="Age")
	private int age;
	@Column(name="Version" )
	private int version;
	
	public Personne() {
		super();
	}

	public Personne(String prenom, String nom, int age, int version) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public static Comparator<Personne> idComparator = new Comparator<Personne>() {

		@Override
		public int compare(Personne o1, Personne o2) {
			long id1 = o1.getId();
			long id2 = o2.getId();
			
			return (int) (id1-id2);
		}
		
	};
	
	
	
	
}
