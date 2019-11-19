package com.Ecommerce.controller;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CommandeRepository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Commande;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;



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
	public Commande addCommande(@RequestParam("username") String username) {
		AppUser u = userRepository.findByUsername(username);
		//AppUser u = userRepository.findById(user.getId()).get();
		Map<Long, LigneCommande> articles= panierService.getAllArticlesPanier(username);
		Commande cmd=new Commande();
		cmd.setDateCommande(LocalDateTime.now());
		commandeRepository.save(cmd);
		cmd.setAppUser(u);
		cmd.getArticles().putAll(articles);
		return  commandeRepository.save(cmd);
		}	
	
	@GetMapping("/get-commandes-user")
	public List<Commande>  getCommandeUser(@RequestParam("idPanier") Long idPanier) {
		AppUser u = userRepository.findById(idPanier).get();
		return  commandeRepository.findByAppUserId(idPanier);
		
		  
		}	

}
