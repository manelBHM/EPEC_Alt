package com.Ecommerce.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.User;

@Service
public class AccountServiceBoutique {
	@Autowired
	private UserRepository userRepository;
	

	
	
	
	public User findUserByUsername(String username) {
    	return userRepository.findByUsername(username);
    	}
	

	
	

	public User saveUser(User u) {
		u.setPassword(u.getPassword());
		return userRepository.save(u);
	}

	

}
