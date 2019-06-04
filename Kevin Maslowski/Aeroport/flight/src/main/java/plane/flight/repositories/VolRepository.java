package plane.flight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import plane.flight.models.Vol;

public interface VolRepository extends JpaRepository<Vol, String> {

	public List<Vol> findByPilote(Integer pilote);
	
}
