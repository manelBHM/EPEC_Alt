package com.example.demo.dao;

import java.util.Comparator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Personne;

public interface dao extends JpaRepository<Personne, Long> {

	public List<Personne> findByNom(String nom);
	
	@Query("select p from Personne p where p.nom like:x order by id")
	public Page<Personne> chercherEtudiant(@Param("x")String mc, Pageable pageable);
	
}
