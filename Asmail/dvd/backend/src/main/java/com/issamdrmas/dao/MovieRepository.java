package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issamdrmas.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByName(String name);

}
