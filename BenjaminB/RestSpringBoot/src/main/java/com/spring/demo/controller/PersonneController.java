package com.spring.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.spring.demo.dao.PersonneRepository;
import com.spring.demo.model.Personne;

@Controller
public class PersonneController {
	@Autowired
	 PersonneRepository personneRepo;

	@GetMapping("/personnes")
	public List<Personne> personne(){
		return personneRepo.findAll();
	}
	
	@PostMapping("/personnes")
	public ResponseEntity<Personne> addPersonne(@RequestBody Personne personne) {
		Personne P = personneRepo.save(personne);
		return new ResponseEntity<>(P, HttpStatus.CREATED);
	}
}
