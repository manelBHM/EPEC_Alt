package com.RestApi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.Dao.RoleRepository;
import com.RestApi.Dao.UserRepository;
import com.RestApi.Entities.AppUser;
import com.RestApi.Entities.UserForm;

@CrossOrigin("*")
@RestController
public class AccountController {

	@Autowired
	private com.RestApi.service.AccountService accountService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/signup")
	public AppUser signup(@RequestBody UserForm userForm) {
		return accountService.saveUser(userForm);
	}

	@PutMapping("/modifier")
	public AppUser modifierDetail(@RequestBody AppUser user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.delete(id);
	}

	@GetMapping("/user-info")
	public AppUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			return accountService.findUserByUsername(username);
		} else {
			String username = principal.toString();
			return accountService.findUserByUsername(username);

		}

	}

}
