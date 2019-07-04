package com.example.dvdstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dvdstore.entity.Panier;

public interface PanierRepo extends JpaRepository<Panier, Long>{

}
