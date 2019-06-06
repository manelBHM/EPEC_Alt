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

import com.springBoot.dao.AdminRepository;
import com.springBoot.entities.Administrateur;

@RestController
public class AdminRestController {
	@Autowired
	private AdminRepository adminRepository;
	
	
	@GetMapping("/listadmins")
	public List<Administrateur> listAdmins(){
		return adminRepository.findAll();
	}
	
	@GetMapping("/listAdmins/{id}")
	public Administrateur getVols(@PathVariable(name="id") Long id){
		return adminRepository.findById(id).get();
	
	}

	@PutMapping("/listAdmins/{id}")
	public Administrateur Update(@PathVariable(name="id") Long id, @RequestBody Administrateur admin){
       admin.setId(id);
		return adminRepository.save(admin);
	}
	
	@PostMapping("/listAdmins/{id}")
	public Administrateur save(@RequestBody Administrateur admin){
		return adminRepository.save(admin);
	}
	
	@DeleteMapping("listAdmins/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		adminRepository.deleteById(id);
	}
	

}
