package org.o7planning.springbooth2.controller;

import java.util.*;

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
	
	

	// HOME URL //
	
	@GetMapping("/")
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
	
	@GetMapping("/display")
	public String display(Model model)
	{
		Iterable<Person> all = personDAO.findAll();

		model.addAttribute("person", all);
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
	@ResponseBody
	@RequestMapping(value = "/alternant/delete/{id}", method = RequestMethod.GET)
	public void deleteAlternant(@PathVariable Integer id)
	{
		personDAO.deleteById(id);
	}


	
	
	// POST IN MY DATABASE MYSQL //
	
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
