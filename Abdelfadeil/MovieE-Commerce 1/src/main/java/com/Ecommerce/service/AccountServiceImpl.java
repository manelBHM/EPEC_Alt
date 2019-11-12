package com.Ecommerce.service;


import com.Ecommerce.entities.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private VerificationTokenService verificationTokenService;
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

		try {
			u.setEmail(userForm.getEmail());
			// u.setIsActive(true);
			u.setUsername(username);
			// AppUser user = null;
			// user = userRepository.save(u);
			u.setPassword(bCryptPasswordEncoder.encode(password));
			 AppRole role =roleRepository.findByRoleName("USER");

			 userRepository.save(u);

			//u.getRoles().add(role);
			//userRepository.CreatePanier(user.getId());
		} catch (Exception e) {
			System.out.println("error de sevgarde " + e);
		}
		verificationTokenService.createVerification(u.getEmail());
	    return userRepository.save(u);
	}
	@Override
	public AppRole saveRole(AppRole r) {
	return roleRepository.save(r);
	}

	@Override
	public AppUser findUserByUsername(String username) {
	AppUser u;
	u =userRepository.findByUsername(username);
	if (u ==null){
		return userRepository.findByEmail(username);
	} else {
		return u;
	}

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
	  	userRepository.deleteById(idUser);
	}


}
