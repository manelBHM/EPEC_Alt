package com.Ecommerce.controller;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CommandeRepository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.Adresse;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Commande;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.ICommande;
import com.Ecommerce.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;



@RestController
@CrossOrigin("*")
@RequestMapping("/commande")
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
	private ICommande commande;
	
	@PostMapping("/create")
	public Commande addCommande(@RequestParam("username") String username) {
		return  commande.passerCommande(username);
		}	
	
	@GetMapping("/get-commandes-user")
	public List<Commande>  getCommandeUser(@RequestParam("username") String username) {
		return  commande.getAllCommandesClient(username);
	}

	@GetMapping("/get-commandes-history")
	public Page<Commande> getHistoryCommandes() {
		return commande.getHistoryCommandes();
	}

	@PostMapping("/apyer")
	public Commande  payerCommande(Long idCommande, String username, Adresse adresse) {
		return  commande.payerCommande(idCommande, username, adresse);
	}

}
