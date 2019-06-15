package com.example.avion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Plane implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String maker;
	String model;
	int capacity;
	String site;
	public Plane(String maker, String model, int capacity, String site) {
		super();
		this.maker = maker;
		this.model = model;
		this.capacity = capacity;
		this.site = site;
	}
	public Plane() {
		super();
	}
	
	
	
}
