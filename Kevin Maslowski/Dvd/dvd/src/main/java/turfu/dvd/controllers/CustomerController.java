package turfu.dvd.controllers;

import java.util.List;
import java.util.Optional;

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

import turfu.dvd.domains.Cart;
import turfu.dvd.domains.Customer;
import turfu.dvd.domains.Dvd;
import turfu.dvd.repositories.CartRepository;
import turfu.dvd.repositories.CustomerRepository;
import turfu.dvd.repositories.DvdRepository;
import turfu.dvd.repositories.OrderRepository;

@RestController
@RequestMapping("/customer")
@CrossOrigin()
public class CustomerController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	DvdRepository dvdRepository;
	
	@Autowired
	CartRepository cartRepo;
	
	@GetMapping
	public List<Customer> listEmp() {
		return customerRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Customer customer) {
		customerRepo.save(customer);
	}
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable("id") long id) {
		return customerRepo.getOne(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") long id) {
		customerRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Customer customer) {
		customerRepo.save(customer);
	}
	
	@GetMapping("/{id}/cart")
	public Cart getMyCart(@PathVariable("id") Long id) {
		return cartRepo.findByCustomerId(id).get();
	}

	@PutMapping("/{id}/cart/update")
	public Cart addToMyCart(@PathVariable("id") Long id, @RequestBody Dvd Dvd) {

		Dvd prod = dvdRepository.findById(Dvd.getDvdId()).get();
		Optional<Cart> optCart = cartRepo.findByCustomerId(id);

		if (!optCart.isPresent()) {

			Cart myCart = new Cart();
			myCart.setCustomerId(id);
			List<Dvd> productList = myCart.getProductList();
			productList.add(prod);
			myCart.setProductList(productList);
			myCart.setAmount(prod.getPrice());

			return cartRepo.save(myCart);
		}
		Cart existingCart = optCart.get();
		List<Dvd> existingList = existingCart.getProductList();
		existingList.add(prod);
		existingCart.setProductList(existingList);
		existingCart.setAmount(calculateCartAmount(existingCart));

		return cartRepo.save(existingCart);

	}
	
	private double calculateCartAmount(Cart cart) {

		double sum = 0;
		for (Dvd p : cart.getProductList()) {
			sum = sum + p.getPrice();
		}
		return sum;
	}

}
