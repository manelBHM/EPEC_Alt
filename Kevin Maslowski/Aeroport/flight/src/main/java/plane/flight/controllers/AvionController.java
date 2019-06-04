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

import plane.flight.models.Avion;
import plane.flight.repositories.AvionRepository;

@RestController
@RequestMapping("/avions")
public class AvionController {
	
	@Autowired
	private AvionRepository avionRepo;
	
	@GetMapping
	public List<Avion> lista() {
		return avionRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Avion avion) {
		avionRepo.save(avion);
	}
	
	@GetMapping("/{id}")
	public Avion get (@PathVariable("id") Integer id) {
		return avionRepo.getOne(id);
	}
	
	@DeleteMapping(path ="/{id}")
	public void delete (@PathVariable Integer id) {
		avionRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Avion avion) {
		avionRepo.save(avion);
	}
	
}
