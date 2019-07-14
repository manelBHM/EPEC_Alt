package org.openup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cd")
public class Dvd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private String price;
	public Dvd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dvd(long id,String photo, String name, String price) {
		super();
		this.id = id;
		this.photo=photo;
		this.name = name;
        this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Dvd [id=" + id + ", photo=" + photo + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
