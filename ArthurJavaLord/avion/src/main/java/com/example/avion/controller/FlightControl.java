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

import com.example.avion.model.Flight;
import com.example.avion.repo.FlightRepo;

@RestController
@RequestMapping("/api/v1/vols")
public class FlightControl {

	@Autowired
	private FlightRepo flightRepo;

	@GetMapping
	public List<Flight> list() {
		return flightRepo.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createPilote(@RequestBody Flight flight) {
		flightRepo.save(flight);
	}

	@GetMapping("/{id}")
	public Flight getOne(@PathVariable("id") long id) {
		return flightRepo.getOne(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable("id") long id) {
		flightRepo.deleteById(id);
	}
	
}
