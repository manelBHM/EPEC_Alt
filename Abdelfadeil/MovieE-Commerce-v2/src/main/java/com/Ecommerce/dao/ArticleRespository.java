package com.Ecommerce.dao;

import com.Ecommerce.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface ArticleRespository extends JpaRepository<Article, Long> {

	
	//public Page<Article> findByUser(@Param("id") Long id, Pageable pageable);
   
    
	//@Query("select a from Article a where a.category.idCategory=:idCategory")
	//public List<Article> searchByCategoryList(@Param("idCategory") Long idCategory);
	//@Query("select a from Article a where a.category.idCategory=:idCategory")
	//public Page<Article> searchByCategoryBage(@Param("idCategory") Long idCategory, Pageable pageable); 
	//@Query("select a from Article a where a.category.idCategory like:idCategory and a.description like:mc")
	//public Page<Article> findByCategoryAndDescriptionContains(Category category, @Param("mc") String mc, Pageable pageable);
	
	public Page<Article> findByDescriptionContains(@Param("mc") String mc, Pageable pageable);
    public Page<Article> findByCategoryId(@Param("id")Long idCategory, Pageable pageable);
	public Page<Article> findByCategoryIdAndDescriptionContains(@Param("id")Long id, @Param("mc") String mc, Pageable pageable);






}
