package org.openup.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.openup.model.Dvd;
import org.openup.model.Item;
import org.openup.repo.DvdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestController {
	
	private List<Dvd> D = new ArrayList<Dvd>();
    @Autowired
	private DvdRepository dvdRepository;
	
  
	

	
	@GetMapping("/home")    // this for the home page on html 
	public String testHome(Model model) throws ClassNotFoundException, SQLException {
		return "home";
	}

	
	
	
	 @RequestMapping(value="/panier" , method = RequestMethod.POST)                  //this to add to Pnier
	 public String takeBanner(Long id ,Model model,Dvd d ) {
			D.add(dvdRepository.getOne(id));
			dvdRepository.saveAll(D);
			model.addAttribute("D", D);
		
		return "paner";
		 
	 }
	 @GetMapping("/paner")    // this to save inside the panier what i add 
		public String testPaner(Model model) throws ClassNotFoundException, SQLException {
		 dvdRepository.saveAll(D);
			model.addAttribute("D", D);
			return "paner";
		}
	 
	 @RequestMapping(value="/DLE", method=RequestMethod.POST)  // to delet by id from the panier
	    public String deletCD( Long id  , Dvd d) {
 	D.clear();
//		 D.removeAll(dvdRepository.deleteById(id));
	 	   return "redirect:/paner/" ;
	    }
	
	
		 
	 

	 
}
