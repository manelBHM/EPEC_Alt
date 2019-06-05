package avions.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import avions.model.Vol;




public interface VolRepository extends JpaRepository<Vol, String> {
	
	
	
	

	@Query("SELECT v FROM Vol v "
			+ "WHERE (v.pilote.id = :pilotid ) ")

	Set<Vol> findFlightsByPilot( long pilotid );
	
	
	

}
