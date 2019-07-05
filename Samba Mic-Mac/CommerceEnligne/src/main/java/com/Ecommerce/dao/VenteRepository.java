package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.User;
import com.Ecommerce.entities.Vente;

public interface VenteRepository extends JpaRepository<Vente, Long>{

}
