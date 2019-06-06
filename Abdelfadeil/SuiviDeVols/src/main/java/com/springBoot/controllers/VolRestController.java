package com.springBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.dao.VolRepository;
import com.springBoot.entities.Vol;

@RestController
@CrossOrigin("*")
public class VolRestController {
	@Autowired
	private VolRepository volRepository;
	
	
	@GetMapping("/listVols")
	public List<Vol> listVols(){
		return volRepository.findAll();
	}
	
	@GetMapping("/listVols/{id}")
	public Vol getVols(@PathVariable(name="id") Long id){
		return volRepository.findById(id).get();
	
	}

	@PutMapping("/listVols/{id}")
	public Vol Update(@PathVariable(name="id") Long id, @RequestBody Vol vol){
       vol.setId(id);
		return volRepository.save(vol);
	}
	
	@PostMapping("/ajoutervol/")
	public Vol save(@RequestBody Vol vol){
		return volRepository.save(vol);
	}
	
	@DeleteMapping(value="listVols/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		volRepository.deleteById(id);
	}
	

}
