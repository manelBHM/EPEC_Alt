package com.alternant.controller;

import java.util.*;
import com.alternant.constructeur.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlternantController {

	private static List<Constructeur> listAlternant = new ArrayList<Constructeur>();

	static {
		listAlternant.add(new Constructeur("Lucky", "Stan", "BNP PARIBAS", "2019-2020", true));
	}



	@GetMapping("/listalternant")
	public String displayAlternant(Model m)
	{
		m.addAttribute("list", listAlternant);

		return "display";
	}




	@GetMapping("/add")
	public String addalternant()
	{
		return "addalternant";
	}




	@PostMapping("/add")

	public String postStagiaire(Model m, @RequestParam(name="nom", required = false) String nom, @RequestParam(name="prenom", required = false) String prenom, @RequestParam(name="entreprise", required = false) String entreprise, @RequestParam(name="annee", required=false) String annee, @RequestParam(name="actif", required=false) Boolean actif)

	{	
		listAlternant.add(new Constructeur(nom, prenom, entreprise, annee, actif));

		m.addAttribute("list", listAlternant);
		
		return "display";
	}





}
