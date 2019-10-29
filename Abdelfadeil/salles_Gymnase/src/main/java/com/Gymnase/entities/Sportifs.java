package com.Gymnase.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Set<Roles> roles= new HashSet<>();
	
	public int getIdSportif() {
		return IdSportif;
	}
	public void setIdSportif(int idSportif) {
		IdSportif = idSportif;
	}
	public  String getNom() {
		return Nom;
	}
	public  void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public  void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public  char getSexe() {
		return Sexe;
	}
	public  void setSexe(char sexe) {
		Sexe = sexe;
	}
	public  int getAge() {
		return Age;
	}
	public  void setAge(int age) {
		Age = age;
	}
	@Id
	private String _id;
	public static int IdSportif;
	public static String Nom;
	public static String Prenom;
	public static char Sexe;
	public static int Age;
	@DBRef
	private Sportifs SportifConseiller;
	@DBRef
	private Sports sports;
	                           
    public Set<Roles> getRoles() {
        return getRoles();
    }       
}
