package com.example.dvdstore.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dvdstore.entity.Customer;
import com.example.dvdstore.entity.Dvd;
import com.example.dvdstore.entity.Order;
import com.example.dvdstore.repo.CustomerRepo;
import com.example.dvdstore.repo.OrderRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	OrderRepo orderRepo;
	
	
	public Customer logCheck(Customer customer) {
		
		return null;
	}
}
