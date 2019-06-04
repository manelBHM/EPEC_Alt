package org.openup.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pilot")
public class Pilote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenome")
	private String prenome;

	public Pilote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pilote(long id, String nom, String prenome) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenome = prenome;
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

	public String getPrenome() {
		return prenome;
	}

	public void setPrenome(String prenome) {
		this.prenome = prenome;
	}

	@Override
	public String toString() {
		return "Pilote [id=" + id + ", nom=" + nom + ", prenome=" + prenome + "]";
	}
	
	

}
