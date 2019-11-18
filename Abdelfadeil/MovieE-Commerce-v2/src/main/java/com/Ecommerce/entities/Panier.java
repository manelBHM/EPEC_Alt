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
@Getter
@Setter
public class Panier implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@OneToOne
    @PrimaryKeyJoinColumn
    private AppUser appUser;
	
	@OneToMany
//	@JsonIgnore
	private Map<Long, LigneCommande> items =new HashMap<Long, LigneCommande>();


}
