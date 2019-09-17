package com.Ecommerce.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.LigneCommandeRespository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierService;

@RestController
@CrossOrigin("*")
@RequestMapping("/panier")
public class PanierController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository  userRepository;
	@Autowired
	private ArticleRespository articleRepository;
	@Autowired
	private PanierRepository panierRepository;
	@Autowired
	private PanierService panierService;
	@Autowired
	private HttpSession session;
	
	
	@PostMapping(value = "/new-panier/{id}")
	public Panier CreatePanier(@PathVariable("id") Long id) 
	    {
		return panierService.CreatePanier(id);
		}
	
	@PostMapping(value = "/add")
	public LigneCommande AddArticlePanier(@RequestParam(name="id") Long id, @RequestBody Article a)
	    {
      //LigneCommande ligneCommande = new LigneCommande();
		return panierService.AddArticlePanier(id, a);
		}
	
	@PutMapping(value = "/update")
	public LigneCommande UpdateArticlePanier(@RequestBody LigneCommande lc)
	{
		return panierService.UpdateArticlePanier(lc);
	}
	
	@DeleteMapping(value = "/update-article/{idArticle}")
	public void modifierArticlePanier(@PathVariable("idArticle") Long idArticle)
	    {
		 panierService.modifierQuantity(idArticle);
		}

	@DeleteMapping(value = "/delete-article/{idPanier}")
	public void DeleteArticlePanier(@PathVariable("idPanier") Long idPanier, Long idArticle)
	    {
		 panierService.DeleteArticlePanier(idPanier, idArticle);
		}
	@GetMapping(value="/get/{id}")
	public LigneCommande getArticlePanier(@PathVariable("id") Long id) {
		return panierService.getArticlePanier(id);	
	}
	
	
	@GetMapping(value="/getAllArticlesList/{id}")
	public Collection<LigneCommande> getAllArticlesPanier(@PathVariable("id") Long id)
	    {
		return   panierService.getAllArticlesPanier(id);
		} 
	
	@GetMapping(value="/getAllArticles-page")
	public Page<LigneCommande> getAllArticlesPanierPage(
			@RequestParam("id") Long id,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="10") int size
			)
	    {
		List<LigneCommande> lcmd=   panierService.getAllArticlesPanier(id);
	    Page<LigneCommande> pages = new PageImpl<LigneCommande>(lcmd, new PageRequest(page,  size), lcmd.size());

		  return pages;
		} 
	
	@DeleteMapping(value="/deleteAllArticles/{idPanier}")
	public void deleteAllArticlesPanier(@PathVariable("idPanier") Long idPanier) 
	        {
		 panierService.deleteAllArticlesPanier(idPanier);
			}
	
	

}