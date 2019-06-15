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

import com.example.avion.model.Plane;
import com.example.avion.repo.PlaneRepo;

@RestController
@RequestMapping("/api/v1/planes")
public class PlaneControl {

	@Autowired
	private PlaneRepo planeRepo;

	@GetMapping
	public List<Plane> list() {
		return planeRepo.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createPilote(@RequestBody Plane plane) {
		planeRepo.save(plane);
	}

	@GetMapping("/{id}")
	public Plane getOne(@PathVariable("id") long id) {
		return planeRepo.getOne(id);
	}
	
	@DeleteMapping
	public void deleteFlight(@PathVariable("id") long id) {
		planeRepo.deleteById(id);
	}
	
}
