package co.simplon;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestPerson {
	private static List<Person> ls = new ArrayList<Person>();
	static {
		ls.add(new Person("1", "Pailleux", "Marie", "09/04/1995", "false", "0", "1"));
		ls.add(new Person("2", "Pailleux", "Marie", "09/04/1995", "false", "0", "1"));
		ls.add(new Person("3", "Pailleux", "Marie", "09/04/1995", "false", "0", "1"));
	}

	@GetMapping("/list")
	public String test(Model model) {
		model.addAttribute("list", ls);
		return "list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		
		return "add";
	}
	
	@GetMapping("/index")
	public String test2(Model model, @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "prenom", required = false) String prenom,
			@RequestParam(value = "dateNaissance", required = false) String dateNaissance,
			@RequestParam(value = "marie", required = false) String marie,
			@RequestParam(value = "nbEnfants", required = false) String nbEnfants,
			@RequestParam(value = "version", required = false) String version) {

		ls.add(new Person(id, nom, prenom, dateNaissance, marie, nbEnfants, version));

		model.addAttribute("list", ls);

		return "index";
	}
}
