package videofutur.dvd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import videofutur.dvd.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{

	List<Products>findAll();
	
	//@Query("SELECT p FROM Products p JOIN p.category c WHERE c.id = :categoryId ")
	List<Products>findByCategoryId(Long categoryId);
	
	
//	@Query("SELECT p from products p"
//			+ "WHERE p.mostRented")
//    List<Products>findBestRated();
	
	
	
	
}
