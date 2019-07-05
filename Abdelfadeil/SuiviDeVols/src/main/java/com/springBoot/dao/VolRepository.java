package com.springBoot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springBoot.entities.Vol;

@CrossOrigin("*")
@RepositoryRestResource
public interface VolRepository extends JpaRepository<Vol, Long>{
	
	@RestResource(path= "/byNoVol")
	public List<Vol> findByNoVolContains(@Param("mc") String mc);
	
	@RestResource(path= "/byNoVolPage")
	public Page<Vol> findByNoVolContains(@Param("mc") String mc, Pageable pageable);

}
