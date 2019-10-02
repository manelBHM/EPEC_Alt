package com.RestApi.service;

import com.RestApi.Entities.AppRole;
import com.RestApi.Entities.AppUser;
import com.RestApi.Entities.UserForm;

public interface AccountService {
	
	public AppUser saveUser(UserForm userForm);
	public AppRole saveRole(AppRole r);
	public AppUser findUserByUsername(String username);
	public void addRoleToUser(String username, String roleName);
	public void deleteUser(Long idUser);
    
}
