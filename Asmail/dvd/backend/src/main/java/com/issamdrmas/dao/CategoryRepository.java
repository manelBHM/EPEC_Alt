package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.issamdrmas.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	//public List<Category> findByName(String name);

}
