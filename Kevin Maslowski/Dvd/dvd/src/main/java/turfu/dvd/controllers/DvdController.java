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
import turfu.dvd.repositories.DvdRepository;

@RestController
@RequestMapping("/dvd")
@CrossOrigin()
public class DvdController {
	
	@Autowired
	DvdRepository dvdRepo;
	
	@GetMapping
	public List<Dvd> listEmp() {
		return dvdRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Dvd dvd) {
		dvdRepo.save(dvd);
	}
	
	@GetMapping("/{id}")
	public Dvd get(@PathVariable("id") long id) {
		return dvdRepo.getOne(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable long id) {
		dvdRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Dvd dvd) {
		dvdRepo.save(dvd);
	}
	
	@GetMapping("/{category}")
	public List<Dvd> getByCategory(@PathVariable("category") int category) {
		return dvdRepo.findByCategory(category);
	}
	
//	@GetMapping("/mostview")
//	public List<Dvd> findAllOrderByViewDesc() {
//		return dvdRepo.findAllOrderByViewDesc();
//	}
	
}
