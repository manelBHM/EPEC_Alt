package turfu.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import turfu.dvd.domains.Dvd;
import turfu.dvd.domains.Orderz;
import turfu.dvd.repositories.OrderRepository;

@RestController
@RequestMapping("/order")
@CrossOrigin()
public class OrderController {

	@Autowired
	OrderRepository orderRepo;
	
	@GetMapping
	public List<Orderz> listEmp() {
		return orderRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Orderz order) {
		orderRepo.save(order);
	}
	
	@GetMapping("/{id}")
	public Orderz get(@PathVariable("id") long id) {
		return orderRepo.getOne(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") long id) {
		orderRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Orderz order) {
		orderRepo.save(order);
	}
	
}
