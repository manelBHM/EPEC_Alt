package com.RestApi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestApi.Dao.RoleRepository;
import com.RestApi.Dao.UserRepository;
import com.RestApi.Entities.AppRole;
import com.RestApi.Entities.AppUser;
import com.RestApi.Entities.UserForm;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public AppUser saveUser(UserForm userForm) {
		
		String password=userForm.getPassword();
		String repassword=userForm.getRepassword();
		if(!(repassword.equals(password))) throw new RuntimeException(repassword+ " Mot de passe n'est pas confirmé");
		String username = userForm.getUsername();
		AppUser appUser= userRepository.findByUsername(username);
		if(appUser!=null) throw new RuntimeException(userForm.getUsername() +" existe déjà");
		AppUser u = new AppUser();
		u.setUsername(username);
		u.setPassword(bCryptPasswordEncoder.encode(password));
		AppUser user = null;
		try {	
		    user = userRepository.save(u);
			//AppRole role =repository.findByRoleName("USER");
		    addRoleToUser(username, "USER");
		} catch (Exception e) {
			System.out.println("error de sevgarde ");
		}
		return user;
		
	}
	@Override
	public AppRole saveRole(AppRole r) {
	return roleRepository.save(r);
	}
	@Override
	public AppUser findUserByUsername(String username) {
	return userRepository.findByUsername(username);
	}
	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole r=roleRepository.findByRoleName(roleName);
	    AppUser user=userRepository.findByUsername(username);
	    user.getRoles().add(r);
		 userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long idUser) {
	  	userRepository.delete(idUser);
	}


}
