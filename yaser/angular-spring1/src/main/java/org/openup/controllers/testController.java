package org.openup.controllers;

import java.util.List;

import org.openup.classes.Pilote;

import org.openup.interfaces.PiloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pilo")
public class testController {
	
	@Autowired
	private PiloteRepository piloteRepository ;
	
	
	@GetMapping
	public List<Pilote> list(){
		return piloteRepository.findAll();	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
 public void creat (@RequestBody Pilote P) {
		piloteRepository.save(P);
		
	}
	
	@GetMapping("{id}")
	public Pilote get(@PathVariable("id") long id) {
		return piloteRepository.getOne(id);
	}
	
	

}
