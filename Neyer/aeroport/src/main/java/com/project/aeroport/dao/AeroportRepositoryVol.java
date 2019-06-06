package com.project.aeroport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.aeroport.entities.Vol;

public interface AeroportRepositoryVol extends JpaRepository<Vol, String>{

	@Query("SELECT e FROM Vol e WHERE e.pilote LIKE :x")
	public List<Vol> searchVolbyPilote(@Param("x")String mc);
	
}
