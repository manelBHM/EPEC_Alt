package com.example.dvdstore.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Orders")
public class Order implements Serializable{

	public Order(List<Dvd> orderList, int total) {
		super();
		this.orderList = orderList;
		this.total = total;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@JoinColumn(name="id")
	@OneToMany(targetEntity = Dvd.class, cascade=CascadeType.ALL)
	List<Dvd> orderList;
	
	int total;
	
//	@OneToOne(targetEntity = Customer.class)
//	@JoinColumn(name="customer_id")
//	Customer customer;
	
	
}
