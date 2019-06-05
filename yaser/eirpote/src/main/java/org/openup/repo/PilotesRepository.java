package org.openup.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.openup.classes.Pilotes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PilotesRepository extends  JpaRepository <Pilotes, Long>{

	
}
