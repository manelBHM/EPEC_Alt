package com.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Panier implements Serializable {


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @PrimaryKeyJoinColumn
    private AppUser appUser;
	
	@OneToMany
//	@JsonIgnore
	private Map<Long, LigneCommande> items =new HashMap<Long, LigneCommande>();


}
