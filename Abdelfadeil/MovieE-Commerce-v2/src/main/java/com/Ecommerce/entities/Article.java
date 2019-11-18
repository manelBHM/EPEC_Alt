package com.Ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article implements Serializable{



	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idArticle;
	private String name;
	private String description;
	private int quantity;
		private double prix;
	private String photo;
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category category;
	private boolean disponible;

	
}
