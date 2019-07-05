package com.springBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.springBoot.dao.AdminRepository;
import com.springBoot.dao.AvionRepository;
import com.springBoot.dao.RoleRepository;
import com.springBoot.dao.VolRepository;
import com.springBoot.entities.Administrateur;
import com.springBoot.entities.Avion;
import com.springBoot.entities.Pilote;
import com.springBoot.entities.Role;
import com.springBoot.entities.Vol;


@SpringBootApplication
public class SuiviDeVolsApplication implements CommandLineRunner {

	List<Role> roles =new ArrayList<Role>();
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	RepositoryRestConfiguration config;
	
	public static void main(String[] args) {
		SpringApplication.run(SuiviDeVolsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Vol.class, Pilote.class, Avion.class, Administrateur.class, Role.class);
	  //  roles.add(new Role("ADMIN", "Admin role"));
//	    roles.add(new Role("USER", "user role"));
//		    for (Role r : roles) {
//			}
//		
		Administrateur a = new Administrateur( "user", "123", roles);
		adminRepository.save(a);

		
	}

}
