package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Commande;
import com.Ecommerce.entities.User;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
