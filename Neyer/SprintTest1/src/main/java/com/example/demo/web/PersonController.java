package com.example.demo.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.PersonRepository;
import com.example.demo.person.Person;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	@Autowired //quand il vas instancier le controller il va chercher un objet qui implémente cette interface qui tu as creer auparavant et tu l'inject
	private PersonRepository personRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		//afficher l lilste d'étudiant
		
		Page<Person> personPage = personRepository.chercherPerson("%"+mc+"%", new PageRequest(p, 2));
		int pagesCount=personPage.getTotalPages();
		int[] pages=new int[pagesCount];
		
		for(int i=0 ; i<pagesCount;i++) {
			pages[i]=i;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("pagePerson", personPage);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "listPerson";
	}	
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formulPerson(Model model) {
		 
		model.addAttribute("person", new Person());
		
		return "formPerson";
	}
	
	@RequestMapping(value="/savePerson",method=RequestMethod.POST)
	public String save(@Valid Person per, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formPerson";
		}
		
		personRepository.save(per);
		
		return "redirect:/person/index";
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Long id) {
		personRepository.deleteById(id);

		return "redirect:/person/index";
	}
	
	@RequestMapping(value="/edit")
	public String modifier(Long id,Model model) {
		
		Person pr = personRepository.getOne(id);
		model.addAttribute("person", pr);

		return "editPerson";
	}
	
	@RequestMapping(value="/updatePerson",method=RequestMethod.POST)
	public String update(@Valid Person per, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "editPerson";
		}
		
		personRepository.save(per);
		
		return "redirect:/person/index";
	}
}