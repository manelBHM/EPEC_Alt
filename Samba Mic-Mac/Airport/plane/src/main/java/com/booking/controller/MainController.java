package com.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booking.models.Pilote;
import com.booking.repository.PiloteRepository;

//@CrossOrigin(origins = "*")
//@RequestMapping("/api")
@Controller
public class MainController {
	
	@Autowired
	PiloteRepository piloteRepository;
	
	@GetMapping("/hello")
	public String getIndex() {
		
		return "home";
	 
	}

	
	@GetMapping("/pilote")
	public List<Pilote> getAllPilote(){
		List<Pilote> pilote = new ArrayList<>();
		piloteRepository.findAll().forEach(pilote::add);
	  return pilote;
	}
	
	@GetMapping(path = "/{id}")
	public Pilote get(@PathVariable("id") long id) {		
		return piloteRepository.getOne(id);
	}
	
	@PostMapping(path = "/pilote/create")
	public Pilote postPilote(@RequestBody Pilote pilote) {
		Pilote _pilote = piloteRepository.save( new Pilote(pilote.getId(),  pilote.getName(), pilote.getSite()));	
		return pilote;
	}
	
	@DeleteMapping(path = "/pilote/{id}")	
	public ResponseEntity<String> deletePilote(@PathVariable("id") long id){
		
	  System.out.println("Delete with ID = " + id + "...");
	  piloteRepository.deleteById(id);
	  
	  return new ResponseEntity<>("Pilote has been delete", HttpStatus.OK);	
	}
	
	@DeleteMapping(path = "/pilote/delete")
	public ResponseEntity<String> deleteAllPilote(){
		System.out.println("Delete all Pilote");
		
		piloteRepository.deleteAll();
		
		return new ResponseEntity<String>("All pilote has been Delete", HttpStatus.OK);
		
	}
	
//	@GetMapping(path = "pilote/name/{name}")
//	public List<Pilote> findByName(@PathVariable String name){
//		
//		List<Pilote> pilote = piloteRepository.findByName(name);
//		return pilote;
//	}
	
	
//	@PostMapping(path = "/pilote/{id}")
//	public ResponseEntity<Pilote> updatePilote(@PathVariable("id") int id, @RequestBody Pilote pilote){
//		
//		System.out.println("Update pilote with ID = " + id + "...");
//		
//		List<Pilote> piloteData = piloteRepository.findById(id);
//		
//		if(piloteData.isEmpty()) {
//			Pilote _pilote = piloteData.get(id);
//			_pilote.setName(pilote.getName());;
//			_pilote.setSite(pilote.getSite());
//			
//			
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Pilote>(HttpStatus.NOT_FOUND);
//		}
//	}

	
//    @GetMapping
//	public List<Pilote> list(){
//		List<Pilote> pilote = new ArrayList<>();
//		
//	    return piloteRepository.findAll();
//	}
//    
//
//	@GetMapping("/pilote")
//	@ResponseBody
//	public List<Pilote> getAllPilote(){
//		List<Pilote> pilote = new ArrayList<>();
//		piloteRepository.findAll().forEach(pilote::add);
//	  return pilote;
//	}
//    
//    
//	
//	@PostMapping
//	@ResponseStatus(HttpStatus.OK)
//    public void create(@RequestBody Pilote pilote) {
//		
//		piloteRepository.save(pilote);
//	}
//	
//	
//	@GetMapping("/{id}")
//	public Pilote get(@PathVariable("id") long id) {
//		
//		return piloteRepository.getOne(id);
//	}
	
	
}
