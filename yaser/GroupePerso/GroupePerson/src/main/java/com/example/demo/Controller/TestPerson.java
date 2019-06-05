package com.example.demo.Controller;

import java.security.Provider.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.Dao;
import com.example.demo.Model.Person;

@Controller
public class TestPerson {

	private static List<Person> ls = new ArrayList<Person>();
	Dao dao = new Dao();

	@GetMapping("/list")
	public String test(Model model) throws ClassNotFoundException, SQLException {
		ls = dao.getAll();

		model.addAttribute("ls", ls);

		return "list";
	}

	@PostMapping("/list")

	public String test2(Model model, @RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "prenom", required = false) String prenom,
			@RequestParam(value = "age", required = false) int age) throws ClassNotFoundException, SQLException {

		dao.insert(nom, prenom, age);
		model.addAttribute("ls", ls);
		ls = dao.getAll();
		return "list";
	}

	
	  @GetMapping("/add") public String addGet(Model model) throws
	  ClassNotFoundException, SQLException {
	  
	  model.addAttribute("ls", ls);
	  
	  return "add"; }
	
	@PostMapping("/add")

	public String deleteBu(Model model, @RequestParam(value = "id", required = false) int id)
			throws ClassNotFoundException, SQLException {

		dao.delete(id);

		model.addAttribute("ls", ls);
		dao.getAll();

		return "redirect:/list/";
	}

}
