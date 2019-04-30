package org.o7planning.springbooth2.dao;

import java.util.*;


import org.o7planning.springbooth2.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person, Integer> {
	
	public List<Person> findAll();
   
}
