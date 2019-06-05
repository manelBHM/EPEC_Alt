package org.openup.pilotes.avions.vols.dao.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openup.pilotes.Pilotes;
import org.openup.pilotes.avions.Avions;
import org.openup.pilotes.avions.vols.Vols;
import org.openup.pilotes.avions.vols.dao.DAO;
import org.openup.pilotes.avions.vols.dao.dae.Dao;
import org.openup.pilotes.avions.vols.dao.dae.dae.Dae;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	private static List<Pilotes> P = new ArrayList<Pilotes>();
	DAO AO = new DAO();
	
	private static List<Avions> A = new ArrayList<Avions>();
	Dao AV = new Dao();
	
	private static List<Vols> V = new ArrayList<Vols>();
	Dae AL = new Dae();
	
	@GetMapping("/home")
	public String test(Model model) throws ClassNotFoundException, SQLException {
		P=AO.getAll();
		model.addAttribute("P", P);
		
		A=AV.getAll();
		model.addAttribute("A", A);
		
		V=AL.getAll();
		model.addAttribute("V", V);

		return "home";
	}
	@GetMapping("/Us")
	public String test1(Model model) throws ClassNotFoundException, SQLException {
		P=AO.getAll();
		model.addAttribute("P", P);
		
		A=AV.getAll();
		model.addAttribute("A", A);

		V=AL.getAll();
		model.addAttribute("V", V);


		return "US";
	}
	
	@GetMapping("/AD")
	public String test2(Model model) throws ClassNotFoundException, SQLException {
		P=AO.getAll();
		model.addAttribute("P", P);
		
		A=AV.getAll();
		model.addAttribute("A", A);

		V=AL.getAll();
		model.addAttribute("V", V);


		return "AD";
	}
	/*
	 * @GetMapping("/PL") public String test6(Model model) throws
	 * ClassNotFoundException, SQLException { P=AO.getAll(); model.addAttribute("P",
	 * P);
	 * 
	 * A=AV.getAll(); model.addAttribute("A", A);
	 * 
	 * 
	 * 
	 * V=AL.getAll(); model.addAttribute("V", V);
	 * 
	 * 
	 * 
	 * return "PL"; }
	 */
	
	@GetMapping("/PL")
	public String Find(Model model, @RequestParam(value = "id2", required = false) Integer id2)
			throws ClassNotFoundException, SQLException {

	
		V=AL.getAll();
  V = AL.find(id2);
		model.addAttribute("V",V);
		

		return "PL";
	}
	
	@PostMapping("/AD")

	public String test3(Model model, @RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "sit", required = false) String sit) throws ClassNotFoundException, SQLException {

		AO.insert(nom,sit);
		model.addAttribute("P", P);
		P = AO.getAll();
		return "AD";
	}

	@PostMapping("/DL")
	public String deleteP(Model model, @RequestParam(value = "id", required = false) int id)
			throws ClassNotFoundException, SQLException {

		AO.delete(id);

		model.addAttribute("P", P);
		P=AO.getAll();

		return "redirect:/AD/";
	}

	
	@PostMapping("/DM")

	public String test4(Model model, @RequestParam(value = "constructeur", required = false) String constructeur,
			@RequestParam(value = "modele", required = false) String modele,@RequestParam(value = "capacite", required = false) int capacite,
			@RequestParam(value = "sitee", required = false) String sitee) throws ClassNotFoundException, SQLException {

		AV.insert(constructeur,modele,capacite,sitee);
		model.addAttribute("A", A);
		A = AV.getAll();
		return "redirect:/AD/";
	}

	@PostMapping("/DT")
	public String deleteA(Model model, @RequestParam(value = "id", required = false) int id)
			throws ClassNotFoundException, SQLException {

		AV.delete(id);

		model.addAttribute("A", A);
		A=AV.getAll();

		return "redirect:/AD/";
	}
	
	@PostMapping("/LM")

	public String test5(Model model, @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "avion", required = false) int avion,@RequestParam(value = "pilote", required = false) int pilote,
			@RequestParam(value = "siteArrivee", required = false) String siteArrivee,@RequestParam(value = "siteDepart", required = false) String siteDepart,
			@RequestParam(value = "heureArrivee", required = false) String heureArrivee,@RequestParam(value = "heureDepart", required = false) String heureDepart) throws ClassNotFoundException, SQLException {

		AL.insert(id,avion,pilote,siteArrivee,siteDepart,heureArrivee,heureDepart);
		model.addAttribute("V", V);
		V = AL.getAll();
		return "redirect:/AD/";
	}

	@PostMapping("/LT")
	public String deleteV(Model model, @RequestParam(value = "id", required = false) int id)
			throws ClassNotFoundException, SQLException {

		AL.delete(id);

		model.addAttribute("V", V);
		V=AL.getAll();

		return "redirect:/AD/";
	}


}
