package com.springBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springBoot.entities.Administrateur;


@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Administrateur, Long>{

}
