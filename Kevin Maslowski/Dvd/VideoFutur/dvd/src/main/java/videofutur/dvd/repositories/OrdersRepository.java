package videofutur.dvd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import videofutur.dvd.entities.Customer;
import videofutur.dvd.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{
	
	
             List<Orders>findByCustomer(Customer customer);

}
