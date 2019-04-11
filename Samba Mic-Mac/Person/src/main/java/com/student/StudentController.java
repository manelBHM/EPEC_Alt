package com.student;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
	

	@Autowired 
	private StudentDOA studentDao;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "index";
	}

	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "index";
		}
		
		return "redirect:/viewstudents";
	}
	
	@RequestMapping(value = "/viewstudents")
	public ModelAndView getAll() {
		
		List<Student> list = studentDao.findAll();
		return new ModelAndView("viewstudents", "list", list);
	}
	
	@RequestMapping(value = "/editstudent/{id}")
	public String edis(@PathVariable int id, ModelMap model) {
	  Student student = studentDao.findOne(id);
	  model.addAttribute("student", student);
	  return "editstudent";
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("student") Student p) {
		
		Student student = studentDao.findOne(p.getId());
		
	 student.setFirstName(p.getFirstName());
	 student.setLastName(p.getLastName());
	 student.setSex(p.getSex());
	 student.setDate(p.getDate());
	 student.setEmail(p.getEmail());

	 studentDao.delete(student);
	 return new ModelAndView("redirect:/viewstudents");
	}
	
	@RequestMapping(value="/deletestudent/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		Student student = studentDao.findOne(id);
		studentDao.delete(student);
		return new ModelAndView("redirect:/viewstudents");
	}
	
	@ModelAttribute("country")
	public List<String> iniliseSection(){
		List<String> country = new ArrayList<String>();
		country.add("Graduate");
		country.add("Post Graduate");
		country.add("Research");
		
		return country;
		
	}
	
	@ModelAttribute("countries")
	public List<String> initilizeCountry(){
		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("FRANCE");
		countries.add("CANADA");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		
		return countries;
		
	}
}
