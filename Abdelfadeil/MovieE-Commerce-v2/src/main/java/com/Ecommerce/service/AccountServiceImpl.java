package com.Ecommerce.service;


import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Panier;
import com.Ecommerce.entities.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PanierRepository panierRepository;
	@Autowired
	private VerificationTokenService verificationTokenService;
	@Autowired
	private SendingMailService mailService;
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
		u.setEmail(userForm.getEmail());
		u.setUsername(username);
		u.setPassword(bCryptPasswordEncoder.encode(password));

		try {
			 AppRole r1 =roleRepository.findByRoleName("USER");
			 AppRole r2 =roleRepository.findByRoleName("ADMIN");
			 u = userRepository.save(u);
			 u.getRoles().add(r1);
			 u.getRoles().add(r2);
		 	 Panier p = new Panier();
			 p.setAppUser(u);
			 p =panierRepository.save(p);
			 System.out.println(p);
		} catch (Exception e) {
			System.out.println("error de sevgarde " + e);
		}
		verificationTokenService.createVerification(userForm.getEmail());
	    return userRepository.save(u);
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
	  	userRepository.deleteById(idUser);
	}

	@Override
	public AppUser findUserByUsernameOREmail(String usernameOrEmail) {
		AppUser u =null;
		u=userRepository.findByUsername(usernameOrEmail);
		if(u== null){
			return userRepository.findByEmail(usernameOrEmail);
		} else {
			return userRepository.findByUsername(usernameOrEmail);
		}

	}

    @Override
	public void resendPassword(Long id)  {
		AppUser u = userRepository.findById(id).get();
		String uuid = UUID.randomUUID().toString();
		u.setPassword(bCryptPasswordEncoder.encode(uuid));
        userRepository.save(u);
		String msg = "Votre mot de passe : "+ uuid;
		mailService.sendingMail(u.getEmail(), msg);

	}



}
