package PersonneController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.Dao.PersonneRepository;
import com.RestApi.Entities.Personne;

@RestController
public class Controller {
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@RequestMapping("/save")
	public Personne savePersonne(Personne p) {
		 personneRepository.save(p);
		 return p;
	}

	@RequestMapping("/update")
	public Personne update(Personne p) {
		 personneRepository.saveAndFlush(p);
		 return p;
	}
	
	@RequestMapping("/get")
	public Personne getPersonne(Long ref) {
	   return personneRepository.findOne(ref);
	}
	
	@RequestMapping("/delete")
	public Personne delete(Long ref) {
	   return personneRepository.findOne(ref);
	}
	
	@RequestMapping("/all")
	public List<Personne> getPersonnes() {
		return personneRepository.findAll(); 
	}
	
	@RequestMapping("/personnes")
	public Page<Personne> getPersonnesPage(int page) {
		return personneRepository.findAll(new PageRequest(page, 5));
	}
	
	@RequestMapping("/personnesParMotCle")
	public Page<Personne> getPersonnesPageCle(String mc,@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size) {
		return personneRepository.chercherMotCle("%"+mc+"%", new PageRequest(page, 5));
	}
	
	

}
