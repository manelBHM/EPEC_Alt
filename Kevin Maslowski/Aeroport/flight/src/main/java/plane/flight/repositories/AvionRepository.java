package plane.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import plane.flight.models.Avion;

public interface AvionRepository extends JpaRepository<Avion, Integer> {
	
}
