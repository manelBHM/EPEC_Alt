package com.Ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Panier implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@OneToOne
    private AppUser user;
	
	@OneToMany
	private Map<Long, LigneCommande> items =new HashMap<Long, LigneCommande>();


}
