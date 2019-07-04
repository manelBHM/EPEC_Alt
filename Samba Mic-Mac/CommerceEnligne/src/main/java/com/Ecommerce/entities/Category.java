package com.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long idCategory;
	private String name;
	private String description;
	
	@OneToMany(mappedBy="category")
	private Collection<Article> articles;

}
