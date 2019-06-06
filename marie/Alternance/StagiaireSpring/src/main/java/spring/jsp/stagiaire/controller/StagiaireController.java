package spring.jsp.stagiaire.controller;
import spring.jsp.stagiaire.constructeur.*;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StagiaireController {

	private static List<Stagiaire> liste = new ArrayList<Stagiaire>();

	static {
		liste.add(new Stagiaire("Yann", "Eloge", "G1234"));
		liste.add(new Stagiaire("Lucky", "Stan", "S9678"));
	}


	@GetMapping("/listeStagiaire")
	public String displayStagiaire(Model model)
	{
		model.addAttribute("listeStagiaire", liste);

		return "listperson";
	}


	@GetMapping("/addStagiaire")
	public String addStagiaire()
	{
		return "addstagiaire";
	}



	@PostMapping("/addStagiaire")

	public String postStagiaire(Model m, @RequestParam(name="nom", required = false) String nom, @RequestParam(name="prenom", required = false) String prenom, @RequestParam(name="matricule", required = false) String matricule)
	{	
		liste.add(new Stagiaire(nom, prenom, matricule));

		m.addAttribute("listeStagiaire", liste);

		return "listperson";
	}

}
