package com.project.aeroport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.aeroport.entities.Avion;

public interface AeroportRepository extends JpaRepository<Avion,Long>{

	//public List<Avion> findAll();
	
//	@Query("select e from Avion e where e.nomAvion like :y")
//	public List<Avion> chercherAvionNom(@Param("y")String mc);
	
}