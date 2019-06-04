package plane.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import plane.flight.models.Pilote;

public interface PiloteRepository extends JpaRepository<Pilote, Integer> {

}
