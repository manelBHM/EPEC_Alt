package com.Ecommerce.dao;

import com.Ecommerce.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin("*")
@RepositoryRestResource
public interface PanierRepository extends JpaRepository<Panier, Long>{
	
	public Panier findByAppUserId(Long id);
   // public List<LigneCommande> findItemsById(@Param("id")Long id);
	
	//@Query("select a from Article a where a.category.idCategory=:idCategory")
		//public List<Article> searchByCategoryList(@Param("idCategory") Long idCategory);
	

}
