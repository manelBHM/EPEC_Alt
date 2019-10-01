package com.SpringSercurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSercurity.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	public Utilisateur findByUsername(String username);

}
