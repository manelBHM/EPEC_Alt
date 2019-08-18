package com.dvdenligne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvdenligne.entity.Langue;

public interface LangueRepo extends JpaRepository<Langue, Long> {


	Langue findLangueById(long id);

	
}

