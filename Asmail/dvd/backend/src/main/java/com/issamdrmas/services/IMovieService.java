package com.issamdrmas.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.issamdrmas.model.Movie;

public interface IMovieService {
	public Movie add(Movie movie);
	public List<Movie> getAll();
	public ResponseEntity<Movie> update(Long id, Movie  movie);
	public ResponseEntity<String> deleteById(Long id);
	public List<Movie> getUsername(String username);
	public ResponseEntity<String>deleteAll();
	public Movie getById(Long id);
}
