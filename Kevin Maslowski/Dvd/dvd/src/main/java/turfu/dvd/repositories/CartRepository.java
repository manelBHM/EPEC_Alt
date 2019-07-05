package turfu.dvd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import turfu.dvd.domains.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	Optional<Cart> findByCustomerId(Long customer_id);

}
