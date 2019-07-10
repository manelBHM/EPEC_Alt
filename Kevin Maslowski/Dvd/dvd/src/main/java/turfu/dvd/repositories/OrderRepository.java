package turfu.dvd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import turfu.dvd.domains.Customer;
import turfu.dvd.domains.Orderz;

public interface OrderRepository extends JpaRepository<Orderz, Long> {
	
	List<Orderz>findByCustomer(Customer customer);
	
}
