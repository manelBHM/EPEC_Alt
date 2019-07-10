package videofutur.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import videofutur.dvd.entities.Orders;
import videofutur.dvd.repositories.OrdersRepository;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	OrdersRepository ordersRepository;

	@GetMapping
	public List<Orders> getOrders() {
		return ordersRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Orders order) {
		ordersRepository.save(order);
	}

	@GetMapping("/{id}")
	public Orders get(@PathVariable("id") Long id) {
		return ordersRepository.getOne(id);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable Long id) {
		ordersRepository.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Orders order) {
		ordersRepository.save(order);
	}

}
