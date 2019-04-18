package org.o7planning.springbooth2.controller;

import java.util.Date;

import org.o7planning.springbooth2.dao.PersonDAO;
import org.o7planning.springbooth2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MainController {
	
	Person p = new Person();

	@Autowired
	private PersonDAO personDAO;

	@GetMapping("/")
	public String displayAlternant(Model model)
	{
		Iterable<Person> all = personDAO.findAll();
		model.addAttribute("person", all);

		return "index";
	}



	@GetMapping("/formulaire")
	public String addAlternant()
	{
		return "form";
	}



	
	
	@PostMapping("/addalternant")

	public String saveAlternant(Model m, @RequestParam(name="firstname", required = false) String firstname, @RequestParam(name="lastname", required = false) String lastname, @RequestParam(name="entreprise", required = false) String entreprise, @RequestParam(name="actif", required = false) String actif)

	{	
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setEntreprise(entreprise);
		p.setActif(actif);

		personDAO.save(p);

		return displayAlternant(m);
	}



}
