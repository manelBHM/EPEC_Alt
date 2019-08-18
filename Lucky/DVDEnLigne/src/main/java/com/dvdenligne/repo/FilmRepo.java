package com.dvdenligne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvdenligne.entity.Film;

public interface FilmRepo extends JpaRepository<Film, Long>{

	Object findCatalogueById(long id);

	
}
