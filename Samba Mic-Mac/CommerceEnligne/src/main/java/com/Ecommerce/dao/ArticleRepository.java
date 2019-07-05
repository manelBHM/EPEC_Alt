package com.Ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

	public Page<Article> findByCategory(Long idCat, Pageable pageable);

}
