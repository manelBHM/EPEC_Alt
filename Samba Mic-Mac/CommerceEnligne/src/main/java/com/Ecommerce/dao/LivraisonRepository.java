package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Livraison;
import com.Ecommerce.entities.User;

public interface LivraisonRepository extends JpaRepository<Livraison, Long>{

}
