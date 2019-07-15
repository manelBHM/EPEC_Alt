package com.dvdenligne.entity;

import javax.persistence.*;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	private long id;
	private int client_id, film_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	
	
}
