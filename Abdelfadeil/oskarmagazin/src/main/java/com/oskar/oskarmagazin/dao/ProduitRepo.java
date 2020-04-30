package com.oskar.oskarmagazin.dao;

import com.oskar.oskarmagazin.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProduitRepo  extends JpaRepository<Produit, Long> {

    public Page<Produit> findByDescriptionContains(@Param("mc") String mc, Pageable pageable);

}

