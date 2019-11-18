package com.Ecommerce.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Commande implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCommand;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate dateCommande;
	@ManyToOne
	@JoinColumn(name="id_appUser")
	private AppUser appUser;
    @JsonManagedReference
	@OneToMany(mappedBy = "commande")
	private Map<Long, LigneCommande> articles = new HashMap<>();
	 
	 
	





	

}
