package com.dvdenligne.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvdenligne.entity.Catalogue;

@Repository
public interface CatalogueRepo extends JpaRepository<Catalogue, Long> {

	Object findCatalogueById(long id);

}
