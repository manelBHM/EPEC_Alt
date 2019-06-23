package com.springBoot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springBoot.entities.Pilote;
@CrossOrigin("*")
@RepositoryRestResource
public interface PiloteRepository extends JpaRepository<Pilote, Long>{

	@RestResource(path= "/byNom")
	public List<Pilote> findByNomContains(@Param("mc") String mc);
	
	@RestResource(path= "/byNomPage")
	public Page<Pilote> findByNomContains(@Param("mc") String mc, Pageable pageable);

}
