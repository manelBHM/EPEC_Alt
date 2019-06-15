package com.example.avion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.avion.model.Plane;

public interface PlaneRepo extends JpaRepository<Plane, Long> {
      
}
