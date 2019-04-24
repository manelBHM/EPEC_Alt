package org.o7planning.springbooth2.controller;

import org.o7planning.springbooth2.dao.PersonDAO;
import org.o7planning.springbooth2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {



	@Autowired
	private PersonDAO personDAO;


	@GetMapping("/")
	public String home()
	{
		return "index";
	}

	
	@GetMapping("/display")
	public String display(Model model)
	{
		Iterable<Person> all = personDAO.findAll();

		model.addAttribute("person", all);
		return "display";
	}

	

	@GetMapping("/formulaire")
	public String addAlternant()
	{
		return "form";
	}


	@PostMapping("/addalternant")

	public String saveAlternant(Model model, @RequestParam(name="firstname", required = false) String nom, @RequestParam(name="lastname", required = false) String prenom, @RequestParam(name="entreprise", required = false) String entreprise, @RequestParam(name="annee", required = false) String annee, @RequestParam(name="actif", required = false) String actif)

	{
		
		try {
			
			Person p = new Person();
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setAnnee(annee);
			p.setEntreprise(entreprise);
			p.setActif(actif);
			personDAO.save(p);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

		return display(model);
	}


}
