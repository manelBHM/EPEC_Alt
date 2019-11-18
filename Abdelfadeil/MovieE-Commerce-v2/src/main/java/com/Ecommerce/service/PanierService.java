package com.Ecommerce.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;

public interface PanierService {
	
	
	
	
	public Panier CreatePanier(Long idUser);
	public LigneCommande  AddArticlePanier(Long idPanier, Article article);
	public void DeleteArticlePanier(Long idPanier , Long idArticle);
	public LigneCommande UpdateArticlePanier(LigneCommande article);
	public LigneCommande getArticlePanier(Long id);
	public void deleteAllArticlesPanier(Long idPanier);
	public Map<Long, LigneCommande> getAllArticlesPanier(Long idPanier) ;
	public Map<Long, LigneCommande> getAllPanier(Long id);
	public void modifierQuantity(Long idArticle);

}
