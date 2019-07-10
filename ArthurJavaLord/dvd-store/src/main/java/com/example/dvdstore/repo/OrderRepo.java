package com.example.dvdstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dvdstore.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
