package videofutur.dvd.controllers;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import videofutur.dvd.entities.Cart;
import videofutur.dvd.entities.Customer;
import videofutur.dvd.entities.Infos;
import videofutur.dvd.entities.Orders;
import videofutur.dvd.entities.Products;
import videofutur.dvd.repositories.CartRepository;
import videofutur.dvd.repositories.CustomerRepository;
import videofutur.dvd.repositories.InfosRepository;
import videofutur.dvd.repositories.OrdersRepository;
import videofutur.dvd.repositories.ProductsRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	InfosRepository infoRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProductsRepository productsRepository;

	@PostMapping("/{id}")
	public Infos SaveUserInfos(@PathVariable("id") Long id) {
		infoRepository.deleteAll();

		Customer user = customerRepository.getOne(id);
		Infos newInfos = new Infos();
		newInfos.setUser_id(id);
		newInfos.setFirstName(user.getFirstName());
		newInfos.setLastName(user.getLastName());
		newInfos.setAdress(user.getAdress());

		newInfos.setOrders(user.getOrders());
		if (cartRepository.findByCustomerId(id).isPresent()) {
			newInfos.setCart(cartRepository.findByCustomerId(id).get());
		}
		return infoRepository.save(newInfos);
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/{id}/orders")
	public List<Orders> getMyOrders(@PathVariable("id") Long id) {
		Customer customer = customerRepository.findById(id).get();

		return ordersRepository.findByCustomer(customer);

	}

	@GetMapping("/{id}/cart")
	public Cart getMyCart(@PathVariable("id") Long id) {
		return cartRepository.findByCustomerId(id).get();
	}

	@PutMapping("/{id}/cart/update")
	public Cart addToMyCart(@PathVariable("id") Long id, @RequestBody Products product) {

		Products prod = productsRepository.findById(product.getId()).get();
		Optional<Cart> optCart = cartRepository.findByCustomerId(id);

		if (!optCart.isPresent()) {

			Cart myCart = new Cart();
			myCart.setCustomerId(id);
			List<Products> productList = myCart.getProductList();
			productList.add(prod);
			myCart.setProductList(productList);
			myCart.setAmount(prod.getPrice());

			return cartRepository.save(myCart);
		}
		Cart existingCart = optCart.get();
		List<Products> existingList = existingCart.getProductList();
		existingList.add(prod);
		existingCart.setProductList(existingList);
		existingCart.setAmount(calculateCartAmount(existingCart));

		return cartRepository.save(existingCart);

	}

//	@PostMapping
//	@ResponseStatus(HttpStatus.OK)
//	public Customer create(@RequestBody Customer customer) {
//		return customerRepository.save(customer);
//	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Customer create(@Valid Customer customer) {
		return customerRepository.save(customer);
	}

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") Long id) {
		return customerRepository.findById(id).get();
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}

	private double calculateCartAmount(Cart cart) {

		double sum = 0;
		for (Products p : cart.getProductList()) {
			sum = sum + p.getPrice();
		}
		return sum;
	}
}
