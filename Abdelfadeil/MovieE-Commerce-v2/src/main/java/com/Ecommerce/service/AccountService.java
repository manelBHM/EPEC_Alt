package com.Ecommerce.service;

import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.UserForm;

public interface AccountService {
	
	public AppUser saveUser(UserForm userForm);
	public AppRole saveRole(AppRole r);
	public AppUser findUserByUsername(String username);
	public void addRoleToUser(String username, String roleName);
	public void deleteUser(Long idUser);
	public AppUser findUserByUsernameOREmail(String usernameOrEmail);
    
}
