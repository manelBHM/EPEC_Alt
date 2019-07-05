package com.project.aeroport;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.project.aeroport.dao.AeroportRepository;
import com.project.aeroport.dao.AeroportRepositoryPilote;
import com.project.aeroport.dao.AeroportRepositoryVol;
import com.project.aeroport.entities.Avion;
import com.project.aeroport.entities.Pilote;
import com.project.aeroport.entities.Vol;

@SpringBootApplication
public class AeroportApplication {

	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(AeroportApplication.class, args);
	AeroportRepository aeroportRepository = ctx.getBean(AeroportRepository.class);
	AeroportRepositoryPilote aeroportRepositoryP = ctx.getBean(AeroportRepositoryPilote.class);
	AeroportRepositoryVol aeroportRepositoryV = ctx.getBean(AeroportRepositoryVol.class);
	
	aeroportRepository.save(new Avion("AIRBUS", "A320", 300, "Nice"));
	aeroportRepository.save(new Avion("BOEING", "B707", 250, "Paris"));
	aeroportRepository.save(new Avion("AIRBUS", "A320", 300, "Toulouse"));
	aeroportRepository.save(new Avion("CARAVELLE", "Caravelle", 200, "Toulouse"));
	aeroportRepository.save(new Avion("BOEING", "B747", 400, "Paris"));
	aeroportRepository.save(new Avion("AIRBUS", "A320", 300, "Grenoble"));
	aeroportRepository.save(new Avion("ATR", "ATR42", 50, "Paris"));
	aeroportRepository.save(new Avion("BOEING", "B727", 300, "Lyon"));
	aeroportRepository.save(new Avion("BOEING", "B727", 300, "Nantes"));
	aeroportRepository.save(new Avion("AIRBUS", "A340", 350, "Bastia"));
	
	aeroportRepositoryP.save(new Pilote("SERGE", "NICE"));
	aeroportRepositoryP.save(new Pilote("JEAN", "PARIS"));
	aeroportRepositoryP.save(new Pilote("CLAUDINE", "GRENOBLE"));
	aeroportRepositoryP.save(new Pilote("ROBERT", "NANTES"));
	aeroportRepositoryP.save(new Pilote("MICHEL", "PARIS"));
	aeroportRepositoryP.save(new Pilote("LUCIENNE", "TOULOUSE"));
	aeroportRepositoryP.save(new Pilote("BERTRAND", "LYON"));
	aeroportRepositoryP.save(new Pilote("HERVE", "BASTIA"));
	aeroportRepositoryP.save(new Pilote("LUC", "PARIS"));
	
	aeroportRepositoryV.save(new Vol( "IT100","07:00:00", "09:00:00","10","1", "NICE", "PARIS"));
	aeroportRepositoryV.save(new Vol( "IT101","11:00:00", "12:00:00", "10","2","PARIS", "TOULOUSE"));
	aeroportRepositoryV.save(new Vol( "IT102","12:00:00", "14:00:00","11","1","PARIS", "NICE"));
	aeroportRepositoryV.save(new Vol( "IT103","09:00:00", "11:00:00","15", "3","GRENOBLE", "TOULOUSE"));
	aeroportRepositoryV.save(new Vol( "IT104","17:00:00", "19:00:00","15", "3", "TOULOUSE", "GRENOBLE"));
	aeroportRepositoryV.save(new Vol( "IT105","06:00:00", "07:00:00", "17", "7", "LYON", "PARIS"));
	aeroportRepositoryV.save(new Vol( "IT106","10:00:00", "13:00:00","19", "8","BASTIA", "PARIS"));
	aeroportRepositoryV.save(new Vol( "IT107","17:00:00", "08:00:00","16", "9","PARIS", "BRIVE"));
	aeroportRepositoryV.save(new Vol( "IT108","19:00:00", "20:00:00","13", "9","BRIVE", "PARIS" ));
	aeroportRepositoryV.save(new Vol( "IT109","18:00:00", "19:00:00", "17","7", "PARIS", "LYON"));
	aeroportRepositoryV.save(new Vol( "IT110","15:00:00", "16:00:00","12", "2","TOULOUSE", "PARIS"));
	aeroportRepositoryV.save(new Vol( "IT111","17:00:00", "19:00:00","11", "4", "NICE", "NANTE"));
	
	}
}