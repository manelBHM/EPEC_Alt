package com.Ecommerce.service;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;

import java.util.Map;

public interface PanierService {
	
	
	
	
	public Panier CreatePanier(Long idUser);
	public LigneCommande  AddArticlePanier(String username, Article article);
	public void DeleteArticlePanier(Long idPanier , Long idArticle);
	public LigneCommande UpdateArticlePanier(LigneCommande article);
	public LigneCommande getArticlePanier(Long id);
	public void deleteAllArticlesPanier(Long idPanier);
	public Map<Long, LigneCommande> getAllArticlesPanier( String username) ;
	public Map<Long, LigneCommande> getAllPanier(Long idUser);
	public void modifierQuantity(Long idArticle);

}
