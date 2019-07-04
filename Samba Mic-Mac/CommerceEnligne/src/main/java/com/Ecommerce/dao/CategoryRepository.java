package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Category;
import com.Ecommerce.entities.User;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
