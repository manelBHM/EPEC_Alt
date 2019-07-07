package com.issamdrmas.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.issamdrmas.dao.MovieRepository;
import com.issamdrmas.model.Movie;
import com.issamdrmas.services.IMovieService;
@Repository
public class MovieImpl implements IMovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie add(Movie movie) {		
	  return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getAll() {
		List<Movie> movies = new ArrayList<Movie>();
		movieRepository.findAll().forEach(movies::add);
		return movies;
	}

	@Override
	public ResponseEntity<Movie> update(Long id, Movie movie) {
		Optional<Movie> mOptional = movieRepository.findById(id);
		if (mOptional.isPresent()) {
			Movie m = mOptional.get();
			m.setId(movie.getId());
			m.setName(movie.getName());
			m.setDescription(movie.getDescription());
			m.setPrice(movie.getPrice());
			m.setCreateAt(movie.getCreateAt());
			m.setCategory(movie.getCategory());
			movieRepository.save(m);
			return new  ResponseEntity<Movie> (movieRepository.save(m), HttpStatus.OK);
		}
		return new  ResponseEntity<Movie> (HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		movieRepository.deleteById(id);
		return new ResponseEntity<String>("Movie has been deleted!", HttpStatus.OK);
	}

	@Override
	public List<Movie> getUsername(String username) {
		List<Movie> movies = movieRepository.findByName(username);
		return movies;
	}

	@Override
	public ResponseEntity<String> deleteAll() {
	movieRepository.deleteAll();
	return new ResponseEntity<String>("All Movies have been deleted!", HttpStatus.OK);
	}

	@Override
	public Movie getById(Long id) {
		Optional<Movie> mOptional = movieRepository.findById(id);
		if (mOptional.isPresent()) {
			Movie m = mOptional.get();
			return m;
		}
		return null;
	}

}
