package videofutur.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import videofutur.dvd.entities.Category;
import videofutur.dvd.repositories.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping
	public List <Category> getCategories(){
				
		return categoryRepository.findAll();
	}
	
	
	
	

}
