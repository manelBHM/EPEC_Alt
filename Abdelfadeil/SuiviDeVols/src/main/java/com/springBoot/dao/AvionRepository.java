package com.springBoot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springBoot.entities.Avion;
import com.springBoot.entities.Pilote;

@RepositoryRestResource
public interface AvionRepository extends JpaRepository<Avion, Long>{

	@RestResource(path= "/byModel")
	public List<Avion> findByModelContains(@Param("mc") String mc);
	
	@RestResource(path= "/byModelPage")
	public Page<Avion> findByModelContains(@Param("mc") String mc, Pageable pageable);
}
