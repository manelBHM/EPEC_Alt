package com.example.dvdstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dvdstore.entity.Customer;
import com.example.dvdstore.entity.Dvd;
import com.example.dvdstore.entity.Order;
import com.example.dvdstore.entity.Panier;
import com.example.dvdstore.repo.CustomerRepo;
import com.example.dvdstore.repo.DvdRepo;
import com.example.dvdstore.repo.OrderRepo;
import com.example.dvdstore.repo.PanierRepo;
import com.example.dvdstore.service.CustomerService;
import com.example.dvdstore.service.DvdService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class StoreController {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	DvdRepo dvdRepo;
	@Autowired
	OrderRepo orderRepo;
	@Autowired
	PanierRepo panierRepo;
	
	@Autowired
	DvdService dvdService;
	@Autowired
	CustomerService customerService;
	
	
	

	List<Dvd> dvdList = new ArrayList<>();

	@GetMapping("/dvds")
	public ResponseEntity<List<Dvd>> showDvds() {
		log.info("Getting all dvds");
		List<Dvd> findAll = dvdService.showDvd();
		return ResponseEntity.ok(findAll);
	}

	@GetMapping("/dvds/{id}")
	public ResponseEntity<Dvd> getOne(@PathVariable("id") long id) {
		log.info("Gettint dvd by id");
		Dvd dvdFromDb = dvdService.getOneDvd(id);
		return ResponseEntity.ok(dvdFromDb);
	}

	@PostMapping("/createdvd")
	public ResponseEntity<String> createDvd(@RequestBody Dvd dvd) {
		dvdService.createDvdd(dvd);
		return ResponseEntity.ok("DVD CREATED");
	}

	@DeleteMapping("/deletedvd/{id}")
	public void deleteDvd(@PathVariable("id") long id) {
              dvdRepo.deleteById(id);	
       }

	@PostMapping("/addtocart")
	public ResponseEntity<String> addToCart(@RequestBody Dvd dvd) {
		Dvd dvdFromSite = dvdService.getOneDvd(dvd.getId());
		if (!dvdList.contains(dvdFromSite)) {
			dvdList.add(dvdFromSite);
		}
		return ResponseEntity.ok("ADDED TO CART");
	}
	
	@PostMapping("/removefromcart")
	public void deleteItem(@RequestBody Dvd dvd) {
		Dvd dvdFromSite = dvdService.getOneDvd(dvd.getId());
		
		dvdList.remove(dvdFromSite);
	}

	@GetMapping("/seecart")
	public ResponseEntity<List<Dvd>> seeCart() {
		return ResponseEntity.ok(dvdList);
	}

	@PostMapping("/createcustomer")
	public ResponseEntity<String> logging(@RequestBody Customer customer) {
	customerRepo.save(customer);
		return ResponseEntity.ok("");
	}

	@GetMapping("/checklog/{login}&{password}")
	public boolean checking(@PathVariable String login,
			@PathVariable String password) {
		
		if(password.equals(customerRepo.checkPassword(login))) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	@PostMapping("/createorder")
	public ResponseEntity<String> createOrder(@RequestBody Order order) {
		orderRepo.save(order);
		return ResponseEntity.ok("ORDER CREATED");
	}
	
	@PostMapping("/createpanier")
	public ResponseEntity<String> createPanier(@RequestBody Panier panier) {
			panierRepo.save(panier);
		return ResponseEntity.ok("PANIER CREATED");
	}
	
	@GetMapping("/showpanier")
	public ResponseEntity<List<Panier>> showPanier() {
		List<Panier> liste = panierRepo.findAll();
		return ResponseEntity.ok(liste);
	}
	
	@GetMapping("/showtotal")
	public int getTotalOrder(){
		int total = 0;
		for(Dvd dvd : dvdList) {
			total+=dvd.getPrice();			
		}
		return total;
	}
	
	@GetMapping("/getpw/{login}")
	public String getPw(@PathVariable String login) {
		return customerRepo.checkPassword(login);
	}
	
	
	
	
	

}
