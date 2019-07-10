package turfu.dvd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import turfu.dvd.domains.Dvd;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
	
	List<Dvd> findAll();
	List<Dvd> findByCategory(int category);
//	List<Dvd> findAllOrderByViewDesc();
}
