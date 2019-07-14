package com.Ecommerce.dao;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ArticleRespository extends JpaRepository<Article, Long> {

	public Page<Article> findByUser(Long id, Pageable pageable);
	
    public Page<Article> findByCategory(Category c, Pageable pageable);
    //select p from Person p where name = :name"
    public List<Article> findByCategory(Category c);

	public Page<Article> findByPannier(Long id, Pageable pageable);


}
