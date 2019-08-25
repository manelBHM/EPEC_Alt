package com.Ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Ecommerce.entities.Adresse;
import com.Ecommerce.entities.Panier;




@CrossOrigin("*")
@RepositoryRestResource
public interface AdresseRepository extends JpaRepository<Adresse, Long>{
	
	public Adresse findByUser(@Param(value="id") Long id);

}
