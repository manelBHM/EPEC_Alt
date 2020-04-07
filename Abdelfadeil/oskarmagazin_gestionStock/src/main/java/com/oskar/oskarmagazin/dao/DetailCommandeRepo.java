package com.oskar.oskarmagazin.dao;

import com.oskar.oskarmagazin.entities.DetailCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailCommandeRepo extends JpaRepository<DetailCommande, Long> {
}
