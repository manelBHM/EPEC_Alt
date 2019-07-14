package com.example.dvdstore.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dvdstore.entity.Dvd;

public interface DvdRepo extends JpaRepository<Dvd, Long>{
	
}
