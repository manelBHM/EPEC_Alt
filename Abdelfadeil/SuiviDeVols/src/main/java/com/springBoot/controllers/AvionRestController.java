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

import com.springBoot.dao.AvionRepository;
import com.springBoot.entities.Avion;

@RestController
public class AvionRestController {
	@Autowired
	private AvionRepository avionRepository;
	
	
	@GetMapping("/listAvions")
	public List<Avion> listAvion(){
		return avionRepository.findAll();
	}
	
	@GetMapping("/listAvions/{id}")
	public Avion getAvion(@PathVariable(name="id") Long id){
		return avionRepository.findById(id).get();
	
	}

	@PutMapping("/listAvions/{id}")
	public Avion Update(@PathVariable(name="id") Long id, @RequestBody Avion avion){
		avion.setId(id);
		return avionRepository.save(avion);
	}
	
	@PostMapping("/listAvions/{id}")
	public Avion save(@RequestBody Avion avion){
		return avionRepository.save(avion);
	}
	
	@DeleteMapping("listAvions/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		avionRepository.deleteById(id);
	}
	

}
