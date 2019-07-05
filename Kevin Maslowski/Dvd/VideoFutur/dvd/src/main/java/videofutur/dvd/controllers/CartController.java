package videofutur.dvd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import videofutur.dvd.repositories.CartRepository;
import videofutur.dvd.repositories.ProductsRepository;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	CartRepository cartRepository;
	
 
}
