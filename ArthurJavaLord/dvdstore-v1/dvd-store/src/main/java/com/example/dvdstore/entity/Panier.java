package com.example.dvdstore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	

	
	@OneToMany(targetEntity = Dvd.class)
	List<Dvd> liste = new ArrayList<>();
	
	int total;
}
