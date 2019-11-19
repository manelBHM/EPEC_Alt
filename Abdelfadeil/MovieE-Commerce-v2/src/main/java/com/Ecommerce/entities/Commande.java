package com.Ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;



@Entity
@Data
 @AllArgsConstructor @Getter @Setter
public class Commande implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCommand;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCommande;
	private String ETAT ="";
	@ManyToOne
	@JoinColumn(name="id_appUser")
	private AppUser appUser;
    @JsonManagedReference
	@OneToMany(mappedBy = "commande")
	private Map<Long, LigneCommande> articles = new HashMap<>();
	 
	 
	public Commande(){
		this.dateCommande = LocalDateTime.now();
	}





	

}
