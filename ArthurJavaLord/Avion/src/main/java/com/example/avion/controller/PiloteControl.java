package com.example.avion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.avion.model.Pilote;
import com.example.avion.repo.PiloteRepo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RestController
@RequestMapping("/api/v1/pilotes")
public class PiloteControl {

	@Autowired
	private PiloteRepo piloteRepo;

	@GetMapping
	public List<Pilote> list() {
		return piloteRepo.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createPilote(@RequestBody Pilote pilote) {
		piloteRepo.save(pilote);
	}

	@GetMapping("/{id}")
	public Pilote getOne(@PathVariable("id") long id) {
		return piloteRepo.getOne(id);
	}
	
	@DeleteMapping
	public void deletePilote(@PathVariable("id") long id) {
		piloteRepo.deleteById(id);
	}
	
}
