package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Pannier;
import com.Ecommerce.entities.User;

public interface PannierRepository extends JpaRepository<Pannier, Long>{

}
