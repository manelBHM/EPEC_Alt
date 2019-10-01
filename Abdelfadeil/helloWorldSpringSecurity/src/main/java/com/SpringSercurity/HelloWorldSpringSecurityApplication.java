package com.SpringSercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.SpringSercurity.dao.RolesRepository;
import com.SpringSercurity.dao.UtilisateurRepository;
import com.SpringSercurity.entities.Roles;
import com.SpringSercurity.entities.Utilisateur;
import com.SpringSercurity.service.UtilisateurServiceImpl;

@SpringBootApplication
public class HelloWorldSpringSecurityApplication implements CommandLineRunner {

	@Autowired
	public RolesRepository rolesRepository;
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	public UtilisateurRepository utilisateurRepository;
	@Autowired
	private UtilisateurServiceImpl utilisateurService;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rolesRepository.save(new Roles(null, "USER"));
		rolesRepository.save(new Roles(null, "ADMIN"));
		utilisateurService.signup("user", "abcd", "abcd");
		utilisateurService.signup("admin", "abcd", "abcd");
		utilisateurService.saveRoleToUser("admin", "ADMIN");
		System.out.println(rolesRepository.findByRoleName("USER"));
		System.out.println(rolesRepository.findByRoleName("ADMIN"));
		System.out.println(utilisateurRepository.findByUsername("user"));
		System.out.println(utilisateurRepository.findByUsername("admin"));

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
