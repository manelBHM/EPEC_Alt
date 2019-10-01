package com.SpringSercurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSercurity.entities.Roles;
import com.SpringSercurity.entities.Utilisateur;

public interface RolesRepository extends JpaRepository<Roles, Long>{
	
	public Roles findByRoleName(String roleName);

}
