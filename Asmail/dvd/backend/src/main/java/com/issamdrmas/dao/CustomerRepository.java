package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.issamdrmas.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByAge(int age);
  
}
