package org.openup.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.openup.dao.EtudeantRepository;
import org.openup.entities.Etudeant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EtudiantControllar {
	

	@Autowired       // this Autowired it's important  when we put our interface insaid the controllar it will make appell
	 private EtudeantRepository etudeantRepositoty;
	 
	
	//and after we will right the method
	
	@RequestMapping(value="/index")  // this it the name of me url and automatqmint it will appel my method Index
	
	public String index(Model model) {

		List<Etudeant> etds=etudeantRepositoty.findAll(); // heat also we make import list  (java util)
		model.addAttribute("etudiant", etds);
		return "etudiant";    // and this it's the name of my page html
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	 public String add(Model model) {
		model.addAttribute("etudiant",new Etudeant()); 
		return "formEtudiant";
	}
	
	@RequestMapping(value="/saveEtudiant",method=RequestMethod.POST)
	 public String save(Etudeant e) {
		etudeantRepositoty.save(e);
		return "formEtudiant";
	}

	 
}
