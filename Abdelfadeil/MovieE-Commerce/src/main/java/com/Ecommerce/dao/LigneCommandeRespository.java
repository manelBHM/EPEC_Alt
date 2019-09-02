package com.Ecommerce.dao;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



public interface LigneCommandeRespository extends JpaRepository<LigneCommande, Long> {
	
	//     public Page<Article> findByCategoryIdCategory(@Param("idCategory")Long idCategory, Pageable pageable);


	






}
