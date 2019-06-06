package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.DAO.DAO;

import Model.Avion;
import Model.Pilote;
import Model.Vol;

import org.springframework.stereotype.Controller;



@Controller

public class ControllerP {
	

	
	DAO dao = new DAO();
	 
	 List<Pilote> liste = new ArrayList<Pilote>();
	 List<Avion> liste2 = new ArrayList<Avion>();
	 List<Vol> liste3 = new ArrayList<Vol>();


	 @RequestMapping(value =  "/Acceuil" , method = RequestMethod.GET)
	    public String AcceuilPage(Model model) {
	 
	        return "Acceuil";
	    }
	
 
	
	 
	 @RequestMapping(value = { "/Admin" }, method = RequestMethod.GET)
	    public String AdminPiloteliste(Model model) {
	 
			liste = dao.getPilote();
			liste2 = dao.getAvion();
			liste3 = dao.getVol();

	        model.addAttribute("listeP", liste);
	        model.addAttribute("listeV2", liste2);
	        model.addAttribute("listeV", liste3);

	 
	        return "Admin";
	    }
	
	 @RequestMapping(value = {"/Pilote"}, method= {RequestMethod.GET})

	    public String DetailPilote(Model model, String name) {
		 
		 String pilote = dao.findPiloteByNom(name);
		 model.addAttribute("pilote", pilote);
		 return "Pilote";
	 }
	 
	 
	 
	 
	 @RequestMapping(value =  "/AddPilote" , method = RequestMethod.GET)
	    public String AddPilote(Model model) {
	 
	        return "AddPilote";
	    }
	 
	 @RequestMapping(value =  "/AddVol" , method = RequestMethod.GET)
	    public String AddVol(Model model) {
	 
	        return "AddVol";
	    }
	 
	 @RequestMapping(value =  "/AddAvion" , method = RequestMethod.GET)
	    public String AddAvion(Model model) {
	 
	        return "AddAvion";
	    }
	 
	 
	 
	 
	 
	 @RequestMapping(value =  "/UpdatePilote" , method = RequestMethod.GET)
	    public String UpdatePilote(Model model) {
	 
	        return "UpdatePilote";
	    }
	 
	 @RequestMapping(value =  "/UpdateVol" , method = RequestMethod.GET)
	    public String UpdateVol(Model model) {
	 
	 
	        return "UpdateVol";
	    }
	 
	 @RequestMapping(value =  "/UpdateAvion" , method = RequestMethod.GET)
	    public String UpdateAvion(Model model) {
	 
	 
	        return "UpdateAvion";
	    }
	 
	 
	 
	 
	 
	 
	 
	
	

}
