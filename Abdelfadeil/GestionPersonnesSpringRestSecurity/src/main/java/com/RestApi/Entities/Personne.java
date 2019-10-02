package com.RestApi.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class Personne implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateNaissance;
	private boolean marie;
	private int nbEnfants;
	private int version;
	
	

	public Personne(String nom, String prenom, Date i, boolean marie, int nbEnfants, int version) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = i;
		this.marie = marie;
		this.nbEnfants = nbEnfants;
		this.version = version;
	}

	

	
	
	
	

}
