package com.Gymnase.services;

import java.util.Collection;

import com.Gymnase.entities.Utilisateur;


public interface UserService {
    Collection<Utilisateur> getAllUsers();
    
    Utilisateur getUserById(Long id);
    
    Utilisateur findByLogin(String login);
    
    Utilisateur saveOrUpdateUser(Utilisateur utilisateur);

	void deleteById(Long id);
}

