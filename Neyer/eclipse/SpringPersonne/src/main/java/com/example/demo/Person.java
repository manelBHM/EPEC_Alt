package com.example.demo;

public class Person {
	
	String id;
	String nom;
	int age;
	public Person(String id, String nom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	

}
