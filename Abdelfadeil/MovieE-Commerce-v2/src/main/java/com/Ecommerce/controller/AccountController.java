package com.Ecommerce.controller;

import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.UserForm;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierService;
import com.Ecommerce.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository repository;
	@Autowired
	private PanierService panierService;
	@Autowired
	private VerificationTokenService verificationTokenService;



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
		userRepository.deleteById(id);
	}
	@GetMapping("/user-info")
	public AppUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
			return accountService.findUserByUsername(username);
		} else {
		  String username = principal.toString();
			return accountService.findUserByUsername(username);

		}

	}

	@GetMapping("/confirmRegistration")
	public AppUser confirmRegistration(@RequestParam(name="token") String token, @RequestParam(name="username") String username) throws Exception {
		  return verificationTokenService.verifyEmail(token, username);

	}

	@PostMapping("/send-password/{id}")
	public void resendPassword( @PathVariable("id") Long id)  {
      accountService.resendPassword(id);

	}

}
