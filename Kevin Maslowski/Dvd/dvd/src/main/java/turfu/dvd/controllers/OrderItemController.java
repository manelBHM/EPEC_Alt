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
import turfu.dvd.domains.OrderItem;
import turfu.dvd.repositories.OrderItemRepository;

@RestController
@RequestMapping("/orderitem")
@CrossOrigin()
public class OrderItemController {
	
	@Autowired
	OrderItemRepository orderitemRepo;
	
	@GetMapping
	public List<OrderItem> listEmp() {
		return orderitemRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody OrderItem orderItem) {
		orderitemRepo.save(orderItem);
	}
	
	@GetMapping("/{id}")
	public OrderItem get(@PathVariable("id") long id) {
		return orderitemRepo.getOne(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") long id) {
		orderitemRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody OrderItem orderItem) {
		orderitemRepo.save(orderItem);
	}
	
}
