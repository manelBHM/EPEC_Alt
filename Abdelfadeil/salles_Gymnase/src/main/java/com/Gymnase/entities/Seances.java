package com.Gymnase.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Seances {
	@Id
	private String id;
	private String Jour;
	private int Houraire;
	private int Duree;
	private String Libelle;
	@DBRef
	private Sportifs SportifEntraineur;

}
