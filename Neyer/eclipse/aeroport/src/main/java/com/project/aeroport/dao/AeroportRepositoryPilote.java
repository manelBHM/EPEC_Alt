package com.project.aeroport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.aeroport.entities.Avion;
import com.project.aeroport.entities.Pilote;

public interface AeroportRepositoryPilote extends JpaRepository<Pilote, Long>{

	@Query("select e from Pilote e where e.nom like :x")
	public List<Pilote> cherhcerPiloteI(@Param("x")String mc);

}
