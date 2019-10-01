package com.SpringSercurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SpringSercurity.dao.UtilisateurRepository;
import com.SpringSercurity.entities.Utilisateur;
import com.SpringSercurity.service.UtilisateurServiceImpl;

@Controller
public class UtilisateurControleur {


  @Autowired
  public UtilisateurRepository utilisateurRepository;
  @Autowired
  public UtilisateurServiceImpl UtilisateurService;
  
  @RequestMapping(value="signup", method=RequestMethod.GET)
  public String signup() {
	  return "signup";
  }

  @RequestMapping(value="/", method=RequestMethod.GET)
   public String loginPage() {
	 return "redirect:/user/home"; 
  }
  
  @RequestMapping(value="/signup", method=RequestMethod.POST)
  public String signup(String username, String password, String repassword) {
	  try {
		  UtilisateurService.signup(username, password, repassword); 	  
		  return "login"; 
	} catch (Exception e) {
		return "signup";
	}
  }
  
//  @RequestMapping(value="/login", method=RequestMethod.POST)
//  public String login(String username, String password) {
//		  UtilisateurService.login(username, password);
//		  return "redirect:/user/home/";
//	 }
  
  
  @RequestMapping(value="/user/home", method=RequestMethod.GET)
  public String home() {
	  return "index";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String login() {
	  return "login";
  }
  
}
