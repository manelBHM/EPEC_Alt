package com.Gymnase.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Gymnase.entities.Gymnases;
import com.Gymnase.entities.Roles;

@RepositoryRestResource
public interface GymnaseRepository extends MongoRepository<Gymnases, String>{

}
