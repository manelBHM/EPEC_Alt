package com.Ecommerce.dao;

import com.Ecommerce.entities.MovementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementStockRepository extends JpaRepository<Long, MovementStock> {
}
