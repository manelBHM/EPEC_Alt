package com.springBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.dao.PiloteRepository;
import com.springBoot.entities.Pilote;

@RestController
public class PiloteRestController {
	@Autowired
	private PiloteRepository piloteRepository;
	
	
	@GetMapping("/listPilotes")
	public List<Pilote> listVols(){
		return piloteRepository.findAll();
	}
	
	@GetMapping("/listPilotes/{id}")
	public Pilote getPilote(@PathVariable(name="id") Long id){
		return piloteRepository.findById(id).get();
	
	}

	@PutMapping("/listPilotes/{id}")
	public Pilote Update(@PathVariable(name="id") Long id, @RequestBody Pilote pilote){
		pilote.setId(id);
		return piloteRepository.save(pilote);
	}
	
	@PostMapping("/listPilotes/{id}")
	public Pilote save(@RequestBody Pilote pilote){
		return piloteRepository.save(pilote);
	}
	
	@DeleteMapping("listPilotes/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		piloteRepository.deleteById(id);
	}
	

}
