package lucky.airport.application.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.*;

import lucky.airport.application.entity.Vol;


@Repository
public interface VolDAO extends JpaRepository<Vol, Long>{

	public Vol findVolById(long id);

}

