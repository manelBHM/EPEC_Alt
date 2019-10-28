package com.Gymnase.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Gymnase.entities.Roles;
import com.Gymnase.entities.Sportifs;

@RepositoryRestResource
public interface SportifRepository extends MongoRepository<Sportifs, String>{

}
