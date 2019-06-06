package co.simplon.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Stage.Stagiaires;

@Controller
public class MainController {

	public static List<Stagiaires> stagiaires = new ArrayList<Stagiaires>();

	static {
		stagiaires.add(new Stagiaires("Dupond", "Jake", "G2037"));
		stagiaires.add(new Stagiaires("Dumond", "Mark", "G3958"));
	}

	
	 @GetMapping("/")
	 public String hello()
	 {
		 return "Bienvenue";
	 }



	@GetMapping("/listStagiaire")
	public String displayStagiaire(Model model)
	{
		model.addAttribute("listStagiaire", stagiaires);

		return "ListStagiaire";
	}


	@GetMapping("/AjouteStagiaire")
	public String AjouteStagiaire()
	{
		return "AjouteStagiaire";
	}



	@PostMapping("/AjouteStagiaire")

	public String postStagiaire(Model m, @RequestParam(name="nom", required = false) String nom, @RequestParam(name="prenom", required = false) String prenom, @RequestParam(name="matricule", required = false) String matricule)
	{	
		stagiaires.add(new Stagiaires(nom, prenom, matricule));

		m.addAttribute("listStagiaire", stagiaires);

		return "ListStagiaire";
	}
}






















