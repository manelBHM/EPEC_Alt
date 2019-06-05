package avions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import avions.model.Pilote;

public interface PiloteRepository extends JpaRepository<Pilote, Long>{
	
	
	public Pilote findPiloteById(long id);

}
