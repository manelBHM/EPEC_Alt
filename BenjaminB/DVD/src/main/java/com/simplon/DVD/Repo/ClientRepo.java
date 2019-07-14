package com.simplon.DVD.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.simplon.DVD.entity.Client;

@Component
public interface ClientRepo extends JpaRepository<Client, Long>{


}