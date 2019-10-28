package com.Gymnase;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Gymnase.dao.GymnaseRepository;
import com.Gymnase.dao.RolesRepository;
import com.Gymnase.dao.SportifRepository;
import com.Gymnase.dao.UtilisateurRepository;
import com.Gymnase.entities.Roles;
import com.Gymnase.entities.Utilisateur;

@SpringBootApplication
public class SallesGymnaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SallesGymnaseApplication.class, args);
	}
	
	
    @Bean
	public CommandLineRunner start(GymnaseRepository gymnaseRepository, SportifRepository sportifRepository, RolesRepository rolesRepository, UtilisateurRepository utilisateurRepository) {
		/*
		 * return args-> { Stream.of("ADMIN", "USER").forEach(r -> {
		 * rolesRepository.save(new Roles(null, r)); utilisateurRepository.save(new
		 * Utilisateur(null, "admin", "1234")); }); };
		 */
    	return null;
	}
}
