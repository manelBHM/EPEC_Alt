package com.personneYT.web;

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

import com.personneYT.dao.EtudiantRepository;
import com.personneYT.entities.Etudiant;

@Controller
@RequestMapping(value = "/Etudiant")						// http://localhost:8080/Etudiant/Index
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@RequestMapping(value = "/Index")
	public String Index(Model model, @RequestParam(name="page", defaultValue = "0")int p,
									 @RequestParam(name="motCle", defaultValue = "")String mc) {
		
		Page<Etudiant> pageEtudiants = etudiantRepository.chercherEtudiants("%" + mc + "%", new PageRequest(p, 5));
		
		int pagesCount = pageEtudiants.getTotalPages();
		int[] pages = new int[pagesCount];
		for(int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}
		
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("pageEtudiants", pageEtudiants);
		model.addAttribute("motCle", mc);
		return "etudiants";
		
	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String formEtudiant(Model model) {
		model.addAttribute("etudiant", new Etudiant());
		return "formEtudiant";
	}
	
	@RequestMapping(value="/SaveEtudiant", method = RequestMethod.POST)
	public String save(@Valid Etudiant et, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formEtudiant";
		}
		etudiantRepository.save(et);
		return "redirect:Index";
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Long id) {
		etudiantRepository.deleteById(id);
		return "redirect:Index";
	}
	
	@RequestMapping(value="/modifier")
	public String modifier(Long id, Model model) {
		Etudiant et = etudiantRepository.getOne(id);
		model.addAttribute("etudiant", et);
		return "modifierEtudiant";
	}
	
	@RequestMapping(value="/UpdateEtudiant", method = RequestMethod.POST)
	public String update(@Valid Etudiant et, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formEtudiant";
		}
		etudiantRepository.save(et);
		return "redirect:Index";
	}
}
