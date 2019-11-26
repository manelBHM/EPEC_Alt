package com.Ecommerce.controller;

import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:4200/**")
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@GetMapping("/getCategories")
	public Page<Category> getCategories(
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size	
			){
		return categoryRepository.findAll( PageRequest.of(page, size));
	}

	@GetMapping("/getCategorie")
	public Category getCategory(@RequestParam(name = "id") Long id){
		return categoryRepository.findById(id).get();
	}

}
