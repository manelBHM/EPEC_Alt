package com.dvdenligne.entity;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

	@Id
	private long id;
	
	private String titre, description_film, date_sortie, duree_film, image, disponible;
	private int prix_film, catalogue_film_id, langue_id;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription_film() {
		return description_film;
	}
	public void setDescription_film(String description_film) {
		this.description_film = description_film;
	}
	public String getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(String date_sortie) {
		this.date_sortie = date_sortie;
	}
	public String getDuree_film() {
		return duree_film;
	}
	public void setDuree_film(String duree_film) {
		this.duree_film = duree_film;
	}
	
	public int getPrix_film() {
		return prix_film;
	}
	public void setPrix_film(int prix_film) {
		this.prix_film = prix_film;
	}
	public int getCatalogue_film_id() {
		return catalogue_film_id;
	}
	public void setCatalogue_film_id(int catalogue_film_id) {
		this.catalogue_film_id = catalogue_film_id;
	}
	public int getLangue_id() {
		return langue_id;
	}
	public void setLangue_id(int langue_id) {
		this.langue_id = langue_id;
	}
	public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
