package com.Gymnase.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Document("Sportifs")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Sportifs {

	@Id
	private String _id;
	private int IdSportif;
	private String Nom;
	private String Prenom;
	private char Sexe;
	private int Age;
	@DBRef
	private Sportifs SportifConseiller;
	@DBRef
	private Sports sports;
	                           
	                          
}
