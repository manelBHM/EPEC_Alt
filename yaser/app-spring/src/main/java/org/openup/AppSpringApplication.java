package org.openup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openup.dao.EtudeantRepository;
import org.openup.entities.Etudeant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class AppSpringApplication {

	public static void main(String[] args) throws ParseException {
	ApplicationContext	ctx=SpringApplication.run(AppSpringApplication.class, args);  //we add ApplicationContext	ctx= and we make import for org.spring
	
	EtudeantRepository  etudeantRepository =ctx.getBean(EtudeantRepository.class);
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	
	etudeantRepository.deleteAll();    // this to don't repat the same list all the time
	etudeantRepository.save(new Etudeant("titi",df.parse("1989-11-20"),"titi@gmail;.com","titi.jpg")); //this i add my first etudiant 
	
	etudeantRepository.save(new Etudeant("toto",df.parse("1989-11-20"),"toto@gmail;.com","toto.jpg")); // my second
	
	etudeantRepository.save(new Etudeant("tomo",df.parse("1989-11-20"),"tomo@gmail;.com","tomo.jpg")); // my theard
	

	
	}	

}
