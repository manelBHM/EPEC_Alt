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

import plane.flight.models.Vol;
import plane.flight.repositories.VolRepository;

@RestController
@RequestMapping("/vols")
public class VolController {
	
	@Autowired
	private VolRepository volRepo;
	
	@GetMapping
	public List<Vol> listv() {
		return volRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Vol vol) {
		volRepo.save(vol);
	}
	
	@GetMapping("/{id}")
	public Vol get (@PathVariable("id") String id) {
		return volRepo.getOne(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete (@PathVariable String id) {
		volRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Vol vol) {
		volRepo.save(vol);
	}
	
	@GetMapping("/listByPilote/{pilote}")
	public List<Vol> showPilotFlight (@PathVariable("pilote") Integer pilote) {
		List<Vol> pilotFlight = volRepo.findByPilote(pilote);
		return pilotFlight;
	}

}
