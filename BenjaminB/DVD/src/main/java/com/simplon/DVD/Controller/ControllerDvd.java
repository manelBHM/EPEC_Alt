package com.simplon.DVD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.DVD.Repo.ClientRepo;
import com.simplon.DVD.Repo.Repository;
import com.simplon.DVD.entity.Client;
import com.simplon.DVD.entity.Dvd;

@RestController
@CrossOrigin
@RequestMapping("/home/")
public class ControllerDvd {

	@Autowired
	Repository repository;
	@Autowired
	ClientRepo clientRepo;
	@GetMapping("/films")
	public List<Dvd> filmLists(){
		return repository.findAll();
	}
	@GetMapping("/clients")
	public List<Client> client(){
		return clientRepo.findAll();
	}
	@PostMapping
	public Dvd save(@RequestBody ControllerDvd controllerDvd, BindingResult bindingResult) {
		return null;
		
	}
}
