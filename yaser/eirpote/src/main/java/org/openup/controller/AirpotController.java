package org.openup.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.GetInstancesFromServiceLoader;
import org.openup.classes.Avions;
import org.openup.classes.Pilotes;
import org.openup.classes.Vols;
import org.openup.repo.AvionsRepository;
import org.openup.repo.PilotesRepository;
import org.openup.repo.VolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AirpotController {
	
	private static List<Pilotes> P = new ArrayList<Pilotes>();
	private static List<Avions> A = new ArrayList<Avions>();
	private static List<Vols> V = new ArrayList<Vols>();
	
	
	@Autowired
	private PilotesRepository pilotesRepository;
	@Autowired
    private AvionsRepository avionsRepository;
	@Autowired
    private VolsRepository volsRepository;
	
	@RequestMapping("/save")   // to complet me detabase
	public String process() {
		
		pilotesRepository.save(new Pilotes(9,"SERGE", "NICE"));
		pilotesRepository.save(new Pilotes(8,"JEAN", "PARIS"));
		pilotesRepository.save(new Pilotes(7,"CLAUDINE", "GRENOBLE"));
		pilotesRepository.save(new Pilotes(6,"ROBERT", "NANTES"));
		pilotesRepository.save(new Pilotes(5,"MICHEL", "PARIS"));
		pilotesRepository.save(new Pilotes(4,"LUCIENNE", "TOULOUSE"));
		pilotesRepository.save(new Pilotes(3,"BERTRAND", "LYON"));
		pilotesRepository.save(new Pilotes(2,"HERVE", "BASTIA"));
		pilotesRepository.save(new Pilotes(1,"LUC", "PARIS"));
		
		/////////
		
		
		
		avionsRepository.save(new Avions(109, "AIRBUS", "A340", 350, "Bastia"));
		avionsRepository.save(new Avions(108, "BOEING", "B727", 300, "Nantes"));
		avionsRepository.save(new Avions(107, "BOEING", "B727", 300, "Lyon"));
		avionsRepository.save(new Avions(106, "ATR", "ATR42", 50, "Paris"));
		avionsRepository.save(new Avions(105, "AIRBUS", "A320", 300, "Grenoble"));
		avionsRepository.save(new Avions(104, "BOEING", "B747", 400, "Paris"));
		avionsRepository.save(new Avions(103, "CARAVELLE", "Caravelle", 200, "Toulouse"));
		avionsRepository.save(new Avions(102, "AIRBUS", "A320", 300, "Toulouse"));
		avionsRepository.save(new Avions(101, "BOEING", "B707", 250, "Paris"));
		avionsRepository.save(new Avions(100,"AIRBUS", "A320", 300, "Nice"));
		
		/////////
		
		
		volsRepository.save(new Vols(111, 101, 4, "NICE", "NANTES", "17:00:00", "19:00:00"));
		volsRepository.save(new Vols(110, 102, 2, "TOULOUSE", "PARIS", "15:00:00", "16:00:00"));
		volsRepository.save(new Vols(109, 107, 7, "PARIS", "LYON", "18:00:00", "19:00:00"));
		volsRepository.save(new Vols(108, 106, 9, "BRIVE", "PARIS", "19:00:00", "20:00:00"));
		volsRepository.save(new Vols(107, 106, 9, "PARIS", "BRIVE", "07:00:00", "08:00:00"));
		volsRepository.save(new Vols(106, 109, 8, "BASTIA", "PARIS", "10:00:00", "13:00:00"));
		volsRepository.save(new Vols(105, 107, 7, "LYON", "PARIS", "06:00:00", "07:00:00"));
		volsRepository.save(new Vols(104, 105, 3, "TOULOUSE", "GRENOBLE", "17:00:00", "19:00:00"));
		volsRepository.save(new Vols(103, 105, 3, "GRENOBLE", "TOULOUSE", "09:00:00", "11:00:00"));
		volsRepository.save(new Vols(102, 101, 1, "PARIS", "NICE", "12:00:00", "14:00:00"));
		volsRepository.save(new Vols(101, 100, 2, "PARIS", "TOULOUSE", "11:00:00", "12:00:00"));
		volsRepository.save(new Vols(100, 100, 1, "NICE", "PARIS", "07:00:00", "09:00:00"));
		return "Done";
	}
    
    
    @GetMapping("/home")    // this for the home page on html 
	public String test(Model model) throws ClassNotFoundException, SQLException {
    
   
		return "home";
	}
    
    @RequestMapping(value="/Us")  // this it the name of me url and automatqmint it will appel my method Index
	
	public String index(Model model) {

		 P=pilotesRepository.findAll(); // heat also we make import list  (java util)
		model.addAttribute("P", P);
		 
		
		 A = avionsRepository.findAll();
		model.addAttribute("A",A);
		
	    V = volsRepository.findAll();
		model.addAttribute("V", V);
		
		
		return "Us";    // and this it's the name of my page html
	}
    
    @GetMapping("/AD")
    public String index2(Model model) {
    	P=pilotesRepository.findAll(); // heat also we make import list  (java util)
		model.addAttribute("P", P);

	    A = avionsRepository.findAll();
		model.addAttribute("A",A);
		
	     V = volsRepository.findAll();
		model.addAttribute("V", V);
		
		return "AD";	
    }
    
////////////////////////////////////////////////////////////////////:
  @RequestMapping(value = "/AT", method=RequestMethod.POST) // this to add new pilot to the list
  public String savePilot(Pilotes p) {
	   pilotesRepository.save(p);
	   return "redirect:/AD/";
	
 }
  
   @RequestMapping(value="/DL", method=RequestMethod.POST) // to delet pilot by the id 
   public String deletePilot(Pilotes p) {
	   pilotesRepository.delete(p);
	   return "redirect:/AD/";
   }
   
   
   @RequestMapping(value="/Up1")  //this to update
   public String updatPilote(Long id, Model model) {
	   
	   Pilotes p = pilotesRepository.getOne(id);
	   model.addAttribute("P", p);
	   return "redirect:/AD/";
   }
   @RequestMapping(value="/Up1",method=RequestMethod.POST) // this to save what i update
   public String saveUpdatPilot(Pilotes p) {
	   
	   pilotesRepository.save(p);
	   return "redirect:/AD/";
   }
   //////////////////////////////////////////////////////////////////
   
   
   
   @RequestMapping(value="/DM", method=RequestMethod.POST) // this to add new avion to the list
   public String saveAvion(Avions a) {
	   avionsRepository.save(a);
	   return "redirect:/AD/";
   }
   @RequestMapping(value="/DT", method=RequestMethod.POST) // to delet avion  by the id 
    public String deletAvion(Avions a) {
	   avionsRepository.delete(a);
	   return "redirect:/AD/";
   }
   
   @RequestMapping(value="/Up2")  //this to update
   public String updatAvion(Long id, Model model) {
	   
	   Avions a = avionsRepository.getOne(id);
	   model.addAttribute("P", a);
	   return "redirect:/AD/";
   }
   @RequestMapping(value="/Up2",method=RequestMethod.POST) // this to save what i update
   public String saveUpdatAvion(Avions a) {
	   avionsRepository.save(a);
	   return "redirect:/AD/";
   }
   //////////////////////////////////////////////////////////////////
   
   
   @RequestMapping(value="/LM", method=RequestMethod.POST) // this to add new vol to the list
   public String saveVol(Vols v) {
	   volsRepository.save(v);
	   return "redirect:/AD/";
   }
   @RequestMapping(value="/LT", method=RequestMethod.POST)  // to delet vol  by the id
   public String deletVol(Vols v) {
	   volsRepository.delete(v);
	   return "redirect:/AD/" ;
   }
   
   
   @RequestMapping(value="/Up3")  //this to update
   public String updatVol(Long id, Model model) {
	   
	  Vols v = volsRepository.getOne(id);
	   model.addAttribute("P", v);
	   return "redirect:/AD/";
   }
   @RequestMapping(value="/Up3",method=RequestMethod.POST) // this to save what i update
   public String saveUpdatVol(Vols v) {
	   volsRepository.save(v);
	   return "redirect:/AD/";
   }
   //////////////////////////////////////////////////////////////////
   
   @GetMapping("/PL")
   public String index3(Model model) {
	   
	   return "PL";
   }
   @RequestMapping(value="/PL",method=RequestMethod.POST)  // find by id 
   public String tt(Model model, @RequestParam(name="id",defaultValue="")int id) {
	   
       List<Vols> vo = volsRepository.findById(id);
	   model.addAttribute("V", vo);
	   
	   return "PL";
   }  
   
}
