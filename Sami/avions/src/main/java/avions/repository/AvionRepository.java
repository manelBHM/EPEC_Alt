package avions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import avions.model.Avion;

public interface AvionRepository extends JpaRepository<Avion, Long>{
	
	

}
