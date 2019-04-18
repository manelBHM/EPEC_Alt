package org.o7planning.springbooth2.dao;

import java.util.*;
import java.util.Date;

import org.o7planning.springbooth2.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {

	public List<Person>findByfirstname(String name);
	public List<Person>findBylastname(String name);
}
