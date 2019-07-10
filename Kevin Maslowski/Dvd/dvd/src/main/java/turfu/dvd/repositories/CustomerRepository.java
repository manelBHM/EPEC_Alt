package turfu.dvd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import turfu.dvd.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
