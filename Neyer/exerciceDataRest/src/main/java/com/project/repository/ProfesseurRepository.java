package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.entities.Professeur;

@RepositoryRestResource(collectionResourceRel="professeurs",path="professeurs")
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

}
