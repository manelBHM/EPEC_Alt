package com.spring.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.spring.demo.model.Personne;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource(
		collectionResourceRel="personnes",
		itemResourceRel="personne",
		path="personnes")
	public interface PersonneRepository extends JpaRepository <	Personne, Integer> {
	List <Personne> findByNom(@Param("nom") String nom);
}