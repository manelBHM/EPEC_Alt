package com.Ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor  @Data
public class MovementStock implements Serializable{
	
	public static final int ENTREE =1;
	public static final int SORTIE =2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMvtStk;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateMvt;
	
	private BigDecimal quantity;
	
	private int typeMvt;

	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;

	public MovementStock(Article article, BigDecimal quantity){
		this.dateMvt =  LocalDateTime.now();
		this.article = article;
		this.quantity = quantity;
	}



	

	
}
