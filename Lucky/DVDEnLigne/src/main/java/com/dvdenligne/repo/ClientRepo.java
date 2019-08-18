package com.dvdenligne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvdenligne.entity.Client;


public interface ClientRepo extends JpaRepository<Client, Long> {

	Object findCatalogueById(long id);

	
}
