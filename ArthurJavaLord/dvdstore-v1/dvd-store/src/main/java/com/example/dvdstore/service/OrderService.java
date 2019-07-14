package com.example.dvdstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dvdstore.entity.Dvd;
import com.example.dvdstore.entity.Order;
import com.example.dvdstore.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	public int getTotalOrder(Order order){
		int total = 0;
		for(Dvd dvd : order.getOrderList()) {
			total+=dvd.getPrice();			
		}
		return total;
	}
	
	
	
}
