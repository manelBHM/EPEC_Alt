package com.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springBoot.dao.AvionRepository;
import com.springBoot.dao.VolRepository;
import com.springBoot.entities.Avion;
import com.springBoot.entities.Vol;


@SpringBootApplication
public class SuiviDeVolsApplication implements CommandLineRunner {

	
	@Autowired
	private VolRepository volRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SuiviDeVolsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Vol a = new Vol("MC 20", null, null, "Kannes");
        	volRepository.save(a);
		}
		
	}

}
