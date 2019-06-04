package plane.flight.controllers;

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

import plane.flight.models.Pilote;
import plane.flight.repositories.PiloteRepository;

@RestController
@RequestMapping("/pilotes")
public class PiloteController {
	
	@Autowired
	private PiloteRepository piloteRepo;
	
	@GetMapping
	public List<Pilote> listp() {
		return piloteRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Pilote pilote) {
		piloteRepo.save(pilote);
	}
	
	@GetMapping("/{id}")
	public Pilote get (@PathVariable("id") Integer id) {
		return piloteRepo.getOne(id);
	}
	
	@DeleteMapping(path ="/{id}")
	public void delete(@PathVariable Integer id) {
		piloteRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Pilote pilote) {
		piloteRepo.save(pilote);
	}
	
}
