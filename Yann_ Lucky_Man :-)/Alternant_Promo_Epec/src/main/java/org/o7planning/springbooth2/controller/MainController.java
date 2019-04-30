package org.o7planning.springbooth2.controller;

import java.util.*;

import org.o7planning.springbooth2.dao.PersonDAO;
import org.o7planning.springbooth2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/api/v1/")
public class MainController {


	@Autowired
	private PersonDAO personDAO;
	
	

	// HOME URL //
	
	@GetMapping("/acceuil")
	public String home()
	{
		return "index";
	}
	
	
	

     // SIGN IN URL //
	
	@GetMapping("/signIn")
	public String signIn()
	{
		return "signIn";
	}

	
	
	// REGISTER URL //
	
	@GetMapping("/register")
	public String register()
	{
		return "registration";
	}


	

	// FORMULAIRE URL//
	
	@GetMapping("/formulaire")
	public String addAlternant()
	{
		return "form";
	}
	
	
	
	// DISPLAY ALTERNANT URL//
	
	@GetMapping("/displayalternant")
	public String display(Model model)
	{
		model.addAttribute("person", personDAO.findAll());
		
		return "display";
	}


	
	// DISPLAY ALTERNANT IN JSON FORMAT //
	@ResponseBody
	@RequestMapping(value = "/alternant", method = RequestMethod.GET)
	public List<Person> getAlternant()
	{
		Iterable<Person> all = personDAO.findAll();
		
		return (List<Person>) all;
	}

	
	// DISPLAY ALTERNANT BY ID //
	@ResponseBody
	@RequestMapping(value = "/alternant/{id}", method = RequestMethod.GET)
	public Optional<Person> getById(@PathVariable("id") Integer id)
	{
		return personDAO.findById(id);
	}
	
	
	
	// DELETE ALTERNANT BY ID //
	@GetMapping("delete/alternant/{id}")
	public String deleteAlternant(@PathVariable Integer id, Model model)
	{
		personDAO.deleteById(id);
		
		return display(model);
	}

	
	
	// UPDATE ALTERNANT BY ID //
	@GetMapping("/alternant/update/{id}")
	public String updateAlternant(@PathVariable Integer id, Person details, Model model)
	{	
		return "form";
	}

	
	
	
	// POST IN MY DATABASE MYSQL //
	
	@PostMapping("/addalternant")

	public String saveAlternant(Model model, Person person, @RequestParam(name="firstname", required = false) String nom, @RequestParam(name="lastname", required = false) String prenom, @RequestParam(name="entreprise", required = false) String entreprise, @RequestParam(name="annee", required = false) String annee, @RequestParam(name="promo", required = false) String promo)

	{

		try {
			person.setNom(nom);
			person.setPrenom(prenom);
			person.setAnnee(annee);
			person.setEntreprise(entreprise);
			person.setPromo(promo);
			
			personDAO.save(person);

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

		return display(model);
	}

	
	

}
