package com.example.avion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pilote implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	String site;
	public Pilote() {
		super();
	}
	public Pilote(String name, String site) {
		super();
		this.name = name;
		this.site = site;
	}
	
}
