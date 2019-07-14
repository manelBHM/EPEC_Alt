package com.example.dvdstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dvdstore.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	
	@Query(value = "select c.password from customer c where c.login = ?1", nativeQuery = true)
	public String checkPassword(String login);
	
//	@Query("select password from customer where login ='x';")
//	void checkLogs(@Param(value = "x") String login);
	
	
	
}
