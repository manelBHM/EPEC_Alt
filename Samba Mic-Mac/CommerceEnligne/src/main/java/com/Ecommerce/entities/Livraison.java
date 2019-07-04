package com.Ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Livraison implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String mode;
	private float price;
	private String adresse;
	private String ville;
	private String pays;
	

}
