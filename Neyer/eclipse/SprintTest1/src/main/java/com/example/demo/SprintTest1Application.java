package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.dao.PersonRepository;
import com.example.demo.person.Person;

@SpringBootApplication
public class SprintTest1Application {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx=SpringApplication.run(SprintTest1Application.class, args);
		
		PersonRepository personResipotory= ctx.getBean(PersonRepository.class);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		personResipotory.save(new Person("VALERIANO","Neyer",df.parse("1995-03-13"),1,"photo1"));
		personResipotory.save(new Person("ABBAS","Yaser",df.parse("1986-12-09"),1,"photo2"));
		personResipotory.save(new Person("SAMPA","Remi",df.parse("1944-06-18"),1,"photo3"));
		
		Page<Person> etds=personResipotory.chercherPerson("%a%",new PageRequest(0,5));
		etds.forEach(e->System.out.println(e.getNom()));
	} 
}