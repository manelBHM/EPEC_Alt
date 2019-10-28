package com.Gymnase.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Gymnases {
	
	@Id
	private String _id;
	private int IdGymnase;
	private String NomGymnase;
	private String Adresse;
	private String Ville;
	private String Surface;
	@DBRef
	private List<Seances> Seances;
	              
	

}
