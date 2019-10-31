package com.Gymnase.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Gymnase.entities.Utilisateur;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{

	public Utilisateur findByUserName(String userName);
}
