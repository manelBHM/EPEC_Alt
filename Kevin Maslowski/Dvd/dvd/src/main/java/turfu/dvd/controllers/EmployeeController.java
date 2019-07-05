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

import turfu.dvd.domains.Employee;
import turfu.dvd.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
@CrossOrigin()
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@GetMapping
	public List<Employee> listEmp() {
		return employeeRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Employee employee) {
		employeeRepo.save(employee);
	}
	
	@GetMapping("/{id}")
	public Employee get(@PathVariable("id") long id) {
		return employeeRepo.getOne(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") long id) {
		employeeRepo.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Employee employee) {
		employeeRepo.save(employee);
	}
	
}
