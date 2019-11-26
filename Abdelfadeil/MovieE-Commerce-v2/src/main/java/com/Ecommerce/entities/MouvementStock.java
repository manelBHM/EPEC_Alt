package com.Ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor  @Data
public class MouvementStock implements Serializable{
	
	public static final int ENTREE =1;
	public static final int SORTIE =2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateMvt;
	
	private float quantity;
	
	private int typeMvt;

	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;

	public MouvementStock(Article article, float quantity){
		this.dateMvt =  LocalDateTime.now();
		this.article = article;
		this.quantity = quantity;
	}



	

	
}
