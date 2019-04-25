package org.o7planning.springbooth2.dao;

import java.util.*;


import org.o7planning.springbooth2.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person, Integer> {
	
	public List<Person> findById(Long id);
	public List<Person>findBynom(String nom);
	public List<Person>findByprenom(String prenom);
	public List<Person>findByEntreprise(String entreprise);
	public List<Person>findByAnnee(String annee);
	public List<Person>findByActif(String actif);
	public void deleteById(Long id);
   
}
