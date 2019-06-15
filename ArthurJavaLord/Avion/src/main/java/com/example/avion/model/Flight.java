package com.example.avion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Flight implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String departureTime;
	
	String arrivingTime;
	
	@ManyToOne(targetEntity = Plane.class)
	@JoinColumn(name="plane_id")
	Plane plane;
	
	@ManyToOne(targetEntity = Pilote.class)
	@JoinColumn(name="pilote_id")
	Pilote pilote;
	
	String departureSite;
	
	String arrivingSite;
	
	public Flight(long id, String departureTime, String arrivingTime, Plane plane, Pilote pilote, String departureSite,
			String arrivingSite) {
		super();
		this.id = id;
		this.departureTime = departureTime;
		this.arrivingTime = arrivingTime;
		this.pilote = pilote;
		this.departureSite = departureSite;
		this.arrivingSite = arrivingSite;
		this.plane = plane;
	}
	public Flight() {
		super();
	}
	
	
	
}
