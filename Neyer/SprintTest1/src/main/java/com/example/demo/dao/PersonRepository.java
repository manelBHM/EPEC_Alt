package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.person.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	public List<Person> findByNom(String n);
	public Page<Person> findByNom(String n,Pageable pageable);
	@Query("select e from Person e where e.nom like :x")
	public Page<Person> chercherPerson(@Param("x")String mc ,Pageable pageable);
	
	@Query("select e from Person e where e.dateNaissance > :x and e.dateNaissance<:y")
	public List<Person> chercherPerson(@Param("x")Date d1,@Param("y") Date d2);
	
	
}