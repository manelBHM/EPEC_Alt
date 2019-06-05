package org.openup;



import org.openup.repo.AvionsRepository;
import org.openup.repo.PilotesRepository;
import org.openup.repo.VolsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EirpoteApplication {

	public static void main(String[] args) {
		ApplicationContext	ctx=SpringApplication.run(EirpoteApplication.class, args);  //we add ApplicationContext	ctx= and we make import for org.spring
		
		PilotesRepository pilotesRepository =ctx.getBean(PilotesRepository.class);
		
		AvionsRepository avionsRepository = ctx.getBean(AvionsRepository.class);
		
		VolsRepository volsRepository = ctx.getBean(VolsRepository.class);
		
	 	
		
		
		
	}

}






















