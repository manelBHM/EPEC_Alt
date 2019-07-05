package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.entities.Cours;

@RepositoryRestResource(collectionResourceRel="cours",path="cours")
public interface CoursRepository extends JpaRepository<Cours, Long>{

}
