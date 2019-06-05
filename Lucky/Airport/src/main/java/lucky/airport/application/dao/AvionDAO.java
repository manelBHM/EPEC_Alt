package lucky.airport.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucky.airport.application.entity.Avion;
import lucky.airport.application.entity.Pilote;

@Repository
public interface AvionDAO extends JpaRepository<Avion, Long>{

	public List<Avion> findAll();

	public Avion findAvionById(long id);

	public void deleteById(long id);
}
