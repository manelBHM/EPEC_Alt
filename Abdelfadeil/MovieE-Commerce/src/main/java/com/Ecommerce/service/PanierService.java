package com.Ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;

public interface PanierService {
	
	public Panier CreatePanier(Long idUser);
	public LigneCommande  AddArticle(LigneCommande article, Long idPanier);
	public void DeleteArtcle(Long idArticle);
	public LigneCommande UpdateArticle(LigneCommande article);
	public LigneCommande getArticle(Long id);
	public Page<LigneCommande>  getAllArticles(Long idPanier);

	
	
	

}
