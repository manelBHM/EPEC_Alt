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

import com.DAO.DAO;

import Model.Personne;

import org.springframework.stereotype.Controller;
@Controller

public class ControllerP {
	
	DAO dao = new DAO();
	 
	 List<Personne> liste = new ArrayList<Personne>();
	
	 @RequestMapping(value = { "/Acceuil" }, method = RequestMethod.GET)
	    public String AcceuilPage(Model model) {
	 
	 
	        return "Acceuil";
	    }
	 
	 
	 @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	    public String personList(Model model) {
	 
			liste = dao.getPersonne();

	        model.addAttribute("listeP", liste);
	 
	        return "index";
	    }
	 
	 
	 
	 @RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	 public  String delete() {
		 
		 
		 
		 return "index";
	 }
	 
	 @RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	 public  String update() {
		 
		 
		 
		 return "update";
	 }


	

}
