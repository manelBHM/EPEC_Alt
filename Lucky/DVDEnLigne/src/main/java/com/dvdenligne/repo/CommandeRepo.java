package com.dvdenligne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvdenligne.entity.Commande;

public interface CommandeRepo extends JpaRepository<Commande, Long> {

	
}
