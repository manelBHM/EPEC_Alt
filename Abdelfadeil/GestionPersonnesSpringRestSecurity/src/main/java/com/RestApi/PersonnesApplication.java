package com.RestApi;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.RestApi.Dao.PersonneRepository;
import com.RestApi.Dao.RoleRepository;
import com.RestApi.Dao.UserRepository;
import com.RestApi.Entities.AppRole;
import com.RestApi.Entities.AppUser;
import com.RestApi.Entities.Personne;
import com.RestApi.service.AccountService;

@SpringBootApplication
public class PersonnesApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	private PersonneRepository personneRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersonnesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Personne.class);
		
		/*
		 * Personne p = new Personne(); p.setNom("ALFADIL"); p.setPrenom("Ismail");
		 * p.setDateNaissance( new Date("04/10/1982")); personneRepository.save(p);
		 */
//		
		
		
		/*
		 * AppRole r2 = new AppRole(null, "ADMIN"); AppRole r1 = new
		 * AppRole(null,"USER");
		 * 
		 * roleRepository.save(r1); roleRepository.save(r2);
		 * 
		 * 
		 * AppUser u1 = new AppUser(); AppUser u2 = new AppUser();
		 * 
		 * u1.setUsername("admin");
		 * u1.setPassword(bCryptPasswordEncoder.encode("abcd"));
		 * 
		 * u2.setUsername("user"); u2.setPassword(bCryptPasswordEncoder.encode("abcd"));
		 * 
		 * userRepository.save(u1); userRepository.save(u2);
		 */
		 
		//accountService.addRoleToUser("admin", "ADMIN");

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
