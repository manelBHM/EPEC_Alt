package com.Ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.Ecommerce.Service.AccountServiceBoutique;
import com.Ecommerce.entities.*;

@SpringBootApplication
public class CommerceEnligneApplication implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration config;
	@Autowired
	private AccountServiceBoutique userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CommerceEnligneApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Article.class, Category.class, Commande.class, Livraison.class, Pannier.class, Payement.class,  User.class, Vente.class );
		
		
	
		
	}
	
	

}
