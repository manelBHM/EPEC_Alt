package com.example.avion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.avion.model.Flight;

public interface FlightRepo extends JpaRepository<Flight, Long> {

}
