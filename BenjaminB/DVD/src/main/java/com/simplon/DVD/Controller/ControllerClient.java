package com.simplon.DVD.Controller;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.DVD.Repo.ClientRepo;
import com.simplon.DVD.entity.Client;


@RestController
@CrossOrigin
@RequestMapping("/users/")
public class ControllerClient {
	@Autowired
	ClientRepo clientRepo;
	@Autowired
	Client client;
	
	@GetMapping("/clients")
	public List<Client> client(){
		return clientRepo.findAll();
	}
	@PostMapping
	public  void addClient(@RequestBody ControllerClient controllerClient, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException("Error couldn't");
		}
		this.clientRepo.save(client.getNom());
		client.getNom();
	}
}
