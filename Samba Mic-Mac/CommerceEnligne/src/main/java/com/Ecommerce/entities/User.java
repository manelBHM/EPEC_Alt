package com.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idUser;
	private String username;
	private String email;
	private String password;
	private String repassword;
	
	@OneToMany(mappedBy="user")
	private Collection<Article> articles;
	
	@OneToMany(mappedBy="user")
	private Collection<Vente> ventes;
	
	@OneToOne
	private Pannier pannier;

}
