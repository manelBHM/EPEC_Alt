package org.openup.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


import org.openup.model.Dvd;
import org.openup.repo.DvdRepository;
import org.openup.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
	
private static List<Dvd> D = new ArrayList<Dvd>();
	
	@Autowired
	private DvdRepository dvdRepository;
	
	
	
	
	@RequestMapping(value="/save")
	public String process(){
		dvdRepository.save(new Dvd (1,"","Glass","10"));
		dvdRepository.save(new Dvd (2,"","The Divergent","10"));
		dvdRepository.save(new Dvd (3,"","La Vie","10"));
		dvdRepository.save(new Dvd (4,"","Demain","10"));
		dvdRepository.save(new Dvd (5,"","Gold","10"));
		dvdRepository.save(new Dvd (6,"","Alita","10"));
	
		return "adminPage";
	}
 
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
    
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        
    	D=dvdRepository.findAll();
    	model.addAttribute("D", D);
        return "adminPage";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "loginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // After user login successfully.
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
 
        D=dvdRepository.findAll();
    	model.addAttribute("D", D);
        return "userInfoPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
    
    @RequestMapping(value="/Up1")  //this to update
    public String updat(Long id, Model model) {
    	
    	Dvd d = dvdRepository.getOne(id);
    	model.addAttribute("d", d);
		return "redirect:/admin/";
    }
    @RequestMapping(value="/Up1",method=RequestMethod.POST) // this to save what i update
    public String saveUpdat(Dvd d) {
 	   dvdRepository.save(d);
 	   return "redirect:/admin/";
    }
    
    @RequestMapping(value="/DM", method=RequestMethod.POST) // this to add new
    public String saveDv(Dvd d) {
 	   dvdRepository.save(d);
 	   return "redirect:/admin/";
    }
    @RequestMapping(value="/DL", method=RequestMethod.POST)  // to delet by id
    public String deletDv(Dvd d) {
 	   dvdRepository.delete(d);
 	   return "redirect:/admin/" ;
    }
 
}