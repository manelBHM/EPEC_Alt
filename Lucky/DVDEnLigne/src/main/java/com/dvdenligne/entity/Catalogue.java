package com.dvdenligne.entity;

import javax.persistence.*;

@Entity
@Table(name = "catalogue_film")
public class Catalogue {

	private String genre, image;
	
	@Id
	private long id;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
