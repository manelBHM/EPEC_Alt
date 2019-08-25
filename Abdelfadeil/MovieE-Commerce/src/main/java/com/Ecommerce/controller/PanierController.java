package com.Ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.LigneCommandeRespository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;

@Controller
@RequestMapping("/panier")
public class PanierController {
	
	
	@Autowired
	private LigneCommandeRespository ligneCommandeRespository;
	@Autowired
	private ArticleRespository articleRespository;
	
	
	@PostMapping("/ajoutArticle/{idPanier}")
	public LigneCommande ajouterArticle(@RequestBody LigneCommande ligneCommande,@PathVariable("idPanier") Long idPanier) {
		List<LigneCommande> panier =  new ArrayList<LigneCommande>();
		panier.add(1, new LigneCommande());
		Article article = articleRespository.findOne(ligneCommande.getIdLigneCommande());
		LigneCommande commande = new LigneCommande();
		commande.setIdLigneCommande(ligneCommande.getIdLigneCommande());
		
		
		
		
		
		return null;
	}

}
