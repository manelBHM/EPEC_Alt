package com.Ecommerce.dao;

import com.Ecommerce.entities.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementStockRepository extends JpaRepository<MouvementStock, Long> {
}
