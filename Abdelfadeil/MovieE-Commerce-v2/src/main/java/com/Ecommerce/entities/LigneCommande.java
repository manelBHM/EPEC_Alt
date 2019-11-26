package com.Ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneCommande implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
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
