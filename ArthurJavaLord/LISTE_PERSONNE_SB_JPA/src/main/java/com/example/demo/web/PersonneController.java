package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.dao;
import com.example.demo.entities.Personne;

@Controller

public class PersonneController {
	@Autowired
	private dao dao;

	@RequestMapping(value = "/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Personne> liste = dao.chercherEtudiant("%" + mc + "%", PageRequest.of(p, 5));
		int pageCount = liste.getTotalPages();
		int[] pages = new int[pageCount];
		for (int i = 0; i < pageCount; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		model.addAttribute("liste", liste);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "personne";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formEtudiant(Model model) {
		model.addAttribute("personne", new Personne());
		return "formEtudiant";
	}

	@RequestMapping(value = "/SaveEtudiant", method = RequestMethod.POST)
	public String save(Personne pe) {
		dao.save(pe);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/supprimer")
	public String supp(Long id) {
		dao.deleteById(id);
		return "redirect:/index";
	}
	
	@GetMapping(value="/modifier")
	public String modifier(Long id, Model model) {
		Personne p = dao.getOne(id);
		model.addAttribute("personne", p);
		return "modifierPersonne";
	}
	
	@RequestMapping(value = "/updateEtudiant", method = RequestMethod.POST)
	public String updateEtudiant(Personne p) {
		p.setVersion(p.getVersion()+1);
		dao.save(p);
		return "redirect:/index";
	}
	
	

}
