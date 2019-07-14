package com.simplon.DVD.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.simplon.DVD.entity.Dvd;

@Component
public interface Repository extends JpaRepository<Dvd, Long>{

}