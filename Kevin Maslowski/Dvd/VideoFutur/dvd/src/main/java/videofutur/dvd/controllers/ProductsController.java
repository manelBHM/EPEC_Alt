package videofutur.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import videofutur.dvd.entities.Category;
import videofutur.dvd.entities.Products;
import videofutur.dvd.repositories.CategoryRepository;
import videofutur.dvd.repositories.ProductsRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping
	public ResponseEntity<List<Products>> getAllProducts() {
		return ResponseEntity.ok(productsRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Products> getProduct(@PathVariable("id") Long id) {

		Products product = productsRepository.findById(id).get();
		return ResponseEntity.ok(product);
	}

	
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	@GetMapping("/category/{category_id}")
	public List<Products> getCategoryProducts(@PathVariable("category_id") Long category_id) {
		//Category category = categoryRepository.getOne(category_id);

		return productsRepository.findByCategoryId(category_id);
	}

	@PostMapping
	public ResponseEntity<Products> addProduct(@RequestBody Products product) {
		return ResponseEntity.ok(productsRepository.save(product));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productsRepository.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Products products) {
		productsRepository.save(products);
	}

}
