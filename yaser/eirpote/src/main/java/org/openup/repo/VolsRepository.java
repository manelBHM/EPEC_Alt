package org.openup.repo;

import java.util.List;

import org.openup.classes.Vols;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VolsRepository extends JpaRepository<Vols, Long> {

	@Query ("select e from Vols e where e.pilote like:x")    // this to call my list from database
    public List<Vols>findById(@Param("x") int pilote);
	

	
}
