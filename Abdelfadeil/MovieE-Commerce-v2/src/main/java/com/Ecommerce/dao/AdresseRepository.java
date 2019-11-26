package com.Ecommerce.dao;

import com.Ecommerce.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;





public interface AdresseRepository extends JpaRepository<Adresse, Long>{
	
	public Adresse findByAppUserId(@Param(value="id") Long id);

}
