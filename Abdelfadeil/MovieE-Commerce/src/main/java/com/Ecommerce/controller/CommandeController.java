package com.Ecommerce.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CommandeRepository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Commande;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierService;



@RestController
@CrossOrigin("*")
@RequestMapping("/commande")
@Controller
public class CommandeController {
	
	
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
	@Autowired
	private CommandeRepository commandeRepository;
	
	@PostMapping("/ajouter")
	public Commande addCommande(Long idPanier) {
		AppUser u = userRepository.findById(idPanier).get();
		Collection<LigneCommande> articles= panierService.getAllArticlesPanier(idPanier);
		Commande cmd=new Commande();
		cmd.setAppUser(u);
		cmd.setArticles(articles);
		return  commandeRepository.save(cmd);
		}	

}
