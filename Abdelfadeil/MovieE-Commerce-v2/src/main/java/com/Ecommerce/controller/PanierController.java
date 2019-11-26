package com.Ecommerce.controller;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
	private PanierServiceImpl panierService;
	@Autowired
	private HttpSession session;
	
	
	@PostMapping(value = "/new-panier/{id}")
	public Panier CreatePanier(@PathVariable("id") Long id) 
	    {
		return panierService.CreatePanier(id);
		}
	
	@PostMapping(value = "/add")
	public LigneCommande AddArticlePanier(@RequestParam(name="username") String username, @RequestBody Article a) throws Exception
	    {
      //LigneCommande ligneCommande = new LigneCommande();
		return panierService.AddArticlePanier(username, a);
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

	@DeleteMapping(value = "/delete-article")
	public void DeleteArticlePanier(@RequestParam("username") String username, @RequestParam("idArticle") Long idArticle)
	    {
		 panierService.DeleteArticlePanier(username, idArticle);
		}
	@GetMapping(value="/get/{id}")
	public LigneCommande getArticlePanier(@PathVariable("id") Long id) {
		return panierService.getArticlePanier(id);	
	}
	
	
	@GetMapping(value="/ge-articles-id-user/{id}")
	public Map<Long, LigneCommande> getAllArticlesPanier(@PathVariable("id") Long idUser)
	    {
		return   panierService.getAllPanier(idUser);
		} 
	
	@GetMapping(value="/get-articles-username")
	public Map<Long, LigneCommande> getAllArticlesPanierPage(
			@RequestParam("username") String username
			)
	    {
			return   panierService.getAllArticlesPanier(username);
	    //Page<LigneCommande> pages = new PageImpl<LigneCommande>(lcmd, PageRequest.of(page, size), lcmd.size());

		}

	@GetMapping(value="/get-total")
	public double getTotal(@RequestParam("username") String username)
	{
		return   panierService.getTotal(username);
	}


	@DeleteMapping(value="/deleteAllArticles/{idPanier}")
	public void deleteAllArticlesPanier(@PathVariable("idPanier") Long idPanier) 
	        {
		 panierService.deleteAllArticlesPanier(idPanier);
			}
	
	

}
