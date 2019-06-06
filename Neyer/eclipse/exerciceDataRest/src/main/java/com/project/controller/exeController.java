package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Cours;
import com.project.entities.Professeur;
import com.project.repository.CoursRepository;
import com.project.repository.ProfesseurRepository;

@RestController
@RequestMapping("/hello")
public class exeController {

	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private CoursRepository coursRepository;

	@GetMapping("/professeur")
	public List<Professeur> getAllprofesseur() {
		return professeurRepository.findAll();
	}

	@GetMapping("/cours")
	public List<Cours> getAllCours() {
		return coursRepository.findAll();
	}

	@PostMapping("/creerProf")
	public ResponseEntity<Professeur> createProf(@RequestBody Professeur p) {

		Professeur pro = professeurRepository.save(p);
		return new ResponseEntity<>(pro, HttpStatus.CREATED);

	}

	@PostMapping("/creercours")
	public ResponseEntity<Cours> createCours(@RequestBody Cours c) {

		Cours cours = coursRepository.save(c);
		return new ResponseEntity<>(cours, HttpStatus.CREATED);
	}

	@DeleteMapping("/professeur/{id}")
	public ResponseEntity<Professeur> deleteProf(@PathVariable @RequestBody long id, Professeur p) {
		professeurRepository.delete(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@DeleteMapping("/cours/{id}")
	public ResponseEntity<Cours> deleteCours(@PathVariable @RequestBody long id, Cours c) {

		coursRepository.delete(id);

		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	
	@PutMapping("updateCours")
	public ResponseEntity<Cours> updateCoursById(@RequestBody long id, Cours c) {
		coursRepository.findOne(id);
		c.setId(id);
		coursRepository.save(c);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@PutMapping("updateProfesseur")
	public ResponseEntity<Professeur> updateProfById(@RequestBody long id, Professeur p) {
		professeurRepository.findOne(id);
		p.setId(id);
		professeurRepository.save(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
