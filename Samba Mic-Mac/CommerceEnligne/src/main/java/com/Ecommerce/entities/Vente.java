package com.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Vente implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long idVente;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateVente;
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	@OneToMany(mappedBy="vente")
	private Collection<Commande> commandes;
	
}
