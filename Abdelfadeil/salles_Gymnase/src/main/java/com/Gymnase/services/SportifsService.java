package com.Gymnase.services;

import java.util.Collection;

import com.Gymnase.entities.Sportifs;

public interface SportifsService {
	
    Collection<Sportifs> getAllSportifs();
    
    Sportifs getSportifsById(Long id);
    
    Sportifs findByLogin(String login);
    
    Sportifs saveOrUpdateSportifs(Sportifs sportifs);

	void deleteById(Long id);
}

