package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Payement;
import com.Ecommerce.entities.User;

public interface PayementRepository extends JpaRepository<Payement, Long>{

}
