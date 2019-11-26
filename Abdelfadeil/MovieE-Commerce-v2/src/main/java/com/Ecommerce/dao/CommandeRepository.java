package com.Ecommerce.dao;

import com.Ecommerce.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface CommandeRepository extends JpaRepository<Commande, Long>{
	
	public  List<Commande> findByUserId(Long id);

}
