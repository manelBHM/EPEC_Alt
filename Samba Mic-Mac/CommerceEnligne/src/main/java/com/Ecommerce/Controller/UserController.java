package com.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Service.AccountServiceBoutique;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.User;

@RestController
public class UserController {
	
	@Autowired
	private AccountServiceBoutique accountServiceBoutique;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public User signUp(@RequestBody User u) {
		String username=u.getUsername();
		User user=accountServiceBoutique.findUserByUsername(username);
		if(user!=null) throw new RuntimeException("This user already exists, Try with an other username");
		String password=u.getPassword();
		String repassword=u.getRepassword();
		if(!password.equals(repassword)) throw new RuntimeException("You must confirm your password");
		User user1=new User();
		user1.setUsername(username);
		user1.setPassword(password);
		accountServiceBoutique.saveUser(user1);
		return (user1);
		
	}
	
	@GetMapping("/users")
	public List<User> users() {
	return userRepository.findAll();
	}
	
	

}
