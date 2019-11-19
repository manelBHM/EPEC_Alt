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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneCommande implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneCommande;
	@ManyToOne( optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name="idArticle")
	private Article article;
	private int quantite;
	 //@JsonBackReference
	//@ManyToOne(optional = true, fetch = FetchType.LAZY)
	//@JoinColumn(name="idCommande")
	//private Commande commande;
	//private double prix;
	/*
	 * @ManyToOne private Panier panier;
	 */
	
}
