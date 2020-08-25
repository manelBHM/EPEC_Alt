package com.oskar.oskarmagazin.dao;

import com.oskar.oskarmagazin.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Produit, Long> {
}
