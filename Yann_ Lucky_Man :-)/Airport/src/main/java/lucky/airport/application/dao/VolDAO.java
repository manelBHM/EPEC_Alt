package lucky.airport.application.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;

import lucky.airport.application.entity.Vol;


@Repository
public interface VolDAO extends JpaRepository<Vol, Long> {

	public List<Vol> findAll();

	public Vol findAvionById(long id);

	public Vol findVolById(long id);
	
}
