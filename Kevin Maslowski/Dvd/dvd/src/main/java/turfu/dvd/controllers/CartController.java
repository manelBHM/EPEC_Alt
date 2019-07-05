package turfu.dvd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turfu.dvd.repositories.CartRepository;
import turfu.dvd.repositories.DvdRepository;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	DvdRepository productsRepository;
	
	@Autowired
	CartRepository cartRepository;
	
}
