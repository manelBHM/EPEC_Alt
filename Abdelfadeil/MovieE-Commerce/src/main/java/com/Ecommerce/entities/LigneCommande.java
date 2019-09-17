package com.Ecommerce.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneCommande implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idLigneCommande;
	@ManyToOne( cascade= {CascadeType.ALL, CascadeType.PERSIST})
	@JoinColumn(name="idArticle")
	private Article article;
	private int quantite;
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	//private double prix;
	/*
	 * @ManyToOne private Panier panier;
	 */
	
}
