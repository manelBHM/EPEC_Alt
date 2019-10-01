package com.SpringSercurity.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSercurity.dao.RolesRepository;
import com.SpringSercurity.dao.UtilisateurRepository;
import com.SpringSercurity.entities.Roles;
import com.SpringSercurity.entities.Utilisateur;

@Service
public class UtilisateurServiceImpl {

	@Autowired
	public UtilisateurRepository utilisateurRepository;
	@Autowired
	public RolesRepository rolesRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Utilisateur signup(String userName, String password, String repassword) {
		
		if(!(repassword.equals(password))) throw new RuntimeException(repassword+ " Mot de passe n'est pas confirmé");
		Utilisateur user= utilisateurRepository.findByUsername(userName);
		if(user!=null) throw new RuntimeException(user.getUsername() +" existe déjà");
		
		Roles r = rolesRepository.findByRoleName("USER");
		Collection<Roles> roles = new ArrayList<Roles>();
		roles.add(r);
		Utilisateur u = new Utilisateur(null, userName,bCryptPasswordEncoder.encode(password), roles);
		return utilisateurRepository.save(u);
	}
	
	public Utilisateur login(String userName, String password) {
		Utilisateur user = utilisateurRepository.findByUsername(userName);
		if(!(user.getPassword().equals(password))) throw new RuntimeException(" Mot de passe n'est pas correct");
		return utilisateurRepository.save(user);
	}
	
	public Utilisateur saveRoleToUser(String userName, String roleName) {
		Utilisateur user= utilisateurRepository.findByUsername(userName);
		Roles r = rolesRepository.findByRoleName("USER");
		
       user.getRoles().add(r);
		return utilisateurRepository.save(user);
	}
}
