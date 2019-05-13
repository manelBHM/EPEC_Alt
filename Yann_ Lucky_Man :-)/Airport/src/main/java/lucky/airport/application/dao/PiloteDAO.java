package lucky.airport.application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lucky.airport.application.entity.Pilote;


@Repository
public interface PiloteDAO extends JpaRepository<Pilote, Long>{

	public List<Pilote> findAll();

	public Pilote findPiloteById(long id);

	public Pilote deletePiloteById(long id);

	public Pilote findPiloteByMatricule(String matricule);
	
}
