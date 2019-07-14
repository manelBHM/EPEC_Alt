package com.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.UserForm;
import com.Ecommerce.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/signup")
	public AppUser signup(@RequestBody UserForm userForm) {
		AppUser appUser= accountService.findUserByUsername(userForm.getUsername());
		if(appUser!=null) throw new RuntimeException(userForm.getUsername() +" existe déjà");
		if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("Mot de passe n'est pas confirmé");
		AppUser u = new AppUser();
		u.setUsername(userForm.getUsername());
		u.setPassword(userForm.getPassword());
		accountService.saveUser(u);
		accountService.addRoleToUser(userForm.getUsername(), "USER");
		 return appUser;
	}
	

}
