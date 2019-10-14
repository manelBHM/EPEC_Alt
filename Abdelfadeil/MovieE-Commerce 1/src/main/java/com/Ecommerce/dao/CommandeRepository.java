package com.Ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Commande;



public interface CommandeRepository extends JpaRepository<Commande, Long>{
	
	public  List<Commande> findByAppUserId(Long id);

}
