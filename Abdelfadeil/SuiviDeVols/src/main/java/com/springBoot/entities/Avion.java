package com.springBoot.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Avion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String model;
	private int capacite;
	private String site;
	
	
	
	
	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avion(String model, int capacite, String site) {
		super();
		this.model = model;
		this.capacite = capacite;
		this.site = site;
	}
	public Avion(Long id, String model, int capacite, String site) {
		super();
		this.id = id;
		this.model = model;
		this.capacite = capacite;
		this.site = site;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	
}
