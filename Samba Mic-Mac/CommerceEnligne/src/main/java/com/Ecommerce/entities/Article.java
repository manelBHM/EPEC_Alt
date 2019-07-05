package com.Ecommerce.entities;

import java.io.Serializable;
import com.Ecommerce.entities.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Article implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long idArticle;
	private String name;
	private String description;
	private int quantity;
	private int price;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	 @ManyToOne
	 @JoinColumn(name="commande") 
	 private Commande commande;
	
	  @ManyToOne
	  @JoinColumn(name="category") 
	 private Category category;
	
	  @ManyToOne
	  @JoinColumn(name="pannier") 
	  private Pannier pannier;
	 
	  
	  
	 
	
	

}
