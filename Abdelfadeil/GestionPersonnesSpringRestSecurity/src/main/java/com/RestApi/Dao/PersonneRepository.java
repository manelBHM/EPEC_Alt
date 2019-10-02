package com.RestApi.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.RestApi.Entities.Personne;
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface PersonneRepository extends JpaRepository<Personne, Long>{

   
    
    @Query("select p from Personne p where p.nom like :x")
    public Page<Personne> chercherMotCle(@Param("x")String mc, Pageable pageable);
    
    @Query("select p from Personne p where p.nom like :x")
    public List<Personne> chercher(@Param("x")String mc	);
	

}
