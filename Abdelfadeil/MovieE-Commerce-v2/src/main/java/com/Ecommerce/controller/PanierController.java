package com.Ecommerce.controller;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

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
			@RequestParam("username") String username,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="10") int size
			)
	    {
		AppUser u=userRepository.findByUsername(username);
		List<LigneCommande> lcmd=   panierService.getAllArticlesPanier(u.getId());
	    Page<LigneCommande> pages = new PageImpl<LigneCommande>(lcmd, PageRequest.of(page, size), lcmd.size());
		  return pages;
		} 
	
	@DeleteMapping(value="/deleteAllArticles/{idPanier}")
	public void deleteAllArticlesPanier(@PathVariable("idPanier") Long idPanier) 
	        {

		 panierService.deleteAllArticlesPanier(idPanier);
			}
	
	

}
