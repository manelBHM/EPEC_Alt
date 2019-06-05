package com.project.dao;


public interface PersonDAO CrudRepository<Person, Long>{

	public List<Person> findByFullNameLike(String name);
	 
    public List<Person> findByDateOfBirthGreaterThan(Date date);
	
}
