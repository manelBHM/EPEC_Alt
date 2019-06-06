package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPerson {

	static List<Person>listPerson=new ArrayList<Person>();
	
	static {
		listPerson.add(new Person("1","Neyer",23));
		listPerson.add(new Person("2","Samba",21));
		listPerson.add(new Person("3","Arthure",34));
	}
	
	@GetMapping("/listPersons")//cette méthode s'execute quand cette page est lancé
	public String affichePerson(ModelMap modelMap) {//modelMap permet d'envoyer une information du back vers le front
		
		modelMap.put("listPerson", listPerson);//"listPerson" est le nom du tableau qu'on veut envoyer
		
		return "listPersons";//nom de la vue vers la quel on envoie le return 
	}
}
