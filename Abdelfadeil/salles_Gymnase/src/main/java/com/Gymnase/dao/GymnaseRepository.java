package com.Gymnase.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Gymnase.entities.Gymnases;
import com.Gymnase.entities.Roles;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface GymnaseRepository extends MongoRepository<Gymnases, String>{

}
