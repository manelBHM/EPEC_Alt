package com.Ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data 
@AllArgsConstructor @NoArgsConstructor 
public class AppUser implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	@ManyToMany
	@JsonIgnore
	private Collection<AppRole> roles= new ArrayList<>();
	private String email;
	private String tel;
	@OneToMany(mappedBy="appUser")
	@JsonIgnore
	private Collection<Adresse> adresses = new ArrayList<>();

	private Boolean isActive=false;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private VerificationToken verificationToken;
	
	
}
