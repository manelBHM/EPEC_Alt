package org.openup.dao;

import java.util.Date;
import java.util.List;

import org.openup.entities.Etudeant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface EtudeantRepository extends JpaRepository<Etudeant, Long>{ 
	

}
