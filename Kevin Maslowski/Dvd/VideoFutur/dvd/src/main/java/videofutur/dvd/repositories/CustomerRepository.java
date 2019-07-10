package videofutur.dvd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import videofutur.dvd.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	

}
