package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.Configuration;

import com.DAO.DAO;

import Model.Produits;

 

@Controller

public class ControllerP {

 	DAO dao = new DAO();
	 
	 List<Produits> liste = new ArrayList<Produits>();
	 
	 @RequestMapping(value = { "/Acceuil" }, method = RequestMethod.GET)
	    public String Acceuil(Model model) {

	 
	        return "Acceuil";
	    }
	 
	 @RequestMapping(value = { "/Liste" }, method = RequestMethod.GET)
	    public String personList(Model model) {
	 
			liste = dao.getProduit();

	        model.addAttribute("listeP", liste);
	 
	        return "Liste";
	    }

	 @RequestMapping(value = { "/Facture" }, method = RequestMethod.GET)
	    public String Facture(Model model) {

	 
	        return "Facture";
	    }
  
}
