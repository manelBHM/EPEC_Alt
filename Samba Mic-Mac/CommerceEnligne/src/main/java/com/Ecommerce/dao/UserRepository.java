package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

     public	User findByUsername(String username);

}
