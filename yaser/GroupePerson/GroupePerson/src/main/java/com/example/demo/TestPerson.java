package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestPerson {
	
	private static List <Person> ls = new ArrayList <Person> (); 
	 
	static {
		
	  ls.add(new Person("1","ABBAS","yaser","1989-12-10","true","1","1"));
	  ls.add(new Person("2","PAILLEUX","mari","1995-12-10","true","2","1"));
	  ls.add(new Person("3","VALERIANO","nayer","1992-12-10","true","3","1"));
	 
	  
	}
	
	@GetMapping("/list")
public String test (Model model) {
		
		model.addAttribute("ls",ls);
		
		return "list";
	}
	
	@GetMapping("/add")
	public String teste (Model model) {
			
		
			return "add";
		}
	
	
	@GetMapping("/index")

	public String test2(Model model, @RequestParam(value="id", required=false) String id, @RequestParam(value="nom", required=false) String nom,  @RequestParam(value="preNom", required=false) String preNom,
			@RequestParam(value="dateNaissance", required=false) String dateNaissance,@RequestParam(value="marie", required=false) String marie,@RequestParam(value="nbEnfants", required=false) String nbEnfants,@RequestParam(value="version", required=false) String version	) 
	{

		
	
     ls.add(new Person(id,nom,preNom,dateNaissance,marie,nbEnfants,version));
     
		
	 
	 model.addAttribute("ls",ls);
	 
	 
		return "index";
	}
	public String test3(Model model, @RequestParam(value="id", required=false) String id, @RequestParam(value="nom", required=false) String nom,  @RequestParam(value="preNom", required=false) String preNom,
			@RequestParam(value="dateNaissance", required=false) String dateNaissance,@RequestParam(value="marie", required=false) String marie,@RequestParam(value="nbEnfants", required=false) String nbEnfants,@RequestParam(value="version", required=false) String version	) 
	{
		
		ls.clear();
		 
		 model.addAttribute("ls",ls);
		return "index";
	}

}
