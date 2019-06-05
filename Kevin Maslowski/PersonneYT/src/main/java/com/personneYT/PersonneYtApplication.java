package com.personneYT;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.personneYT.dao.EtudiantRepository;
import com.personneYT.entities.Etudiant;

@SpringBootApplication
public class PersonneYtApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(PersonneYtApplication.class, args);
		
		ApplicationContext ctx = SpringApplication.run(PersonneYtApplication.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		etudiantRepository.save(new Etudiant("Kevin Maslowski", df.parse("1992-06-11"), "kevinmaslowski@gmail.com", "maslowski.jpg"));
		etudiantRepository.save(new Etudiant("Julien Launay", df.parse("1992-11-28"), "julienlaunay35@gmail.com", "launay.jpg"));
		etudiantRepository.save(new Etudiant("Yaser Abbas", df.parse("1989-01-01"), "y.abbas@groupeonepoint.com", "abbas.jpg"));
		etudiantRepository.save(new Etudiant("Laura Maslowski", df.parse("1997-02-18"), "lauramaslowski@gmail.com", "Lmaslowski.jpg"));
		etudiantRepository.save(new Etudiant("Thomas Solbes", df.parse("1992-02-11"), "thomassolbes@gmail.com", "solbes.jpg"));
		etudiantRepository.save(new Etudiant("Aurore Morizot", df.parse("1988-05-09"), "auroremorizot@gmail.com", "morizot.jpg"));
		
		Page<Etudiant> etds = etudiantRepository.findAll(new PageRequest(0, 5));
		etds.forEach(e->System.out.println(e.getNom()));
		
		Page<Etudiant> etds1 = etudiantRepository.chercherEtudiants("%Y%", new PageRequest(0, 5));
		etds1.forEach(e->System.out.println(e.getNom()));
		
	}

}
