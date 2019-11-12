package com.Ecommerce.dao;

import com.Ecommerce.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String username);
	public AppUser findByEmail(String email);
	public List<AppUser> findByUsernameOrEmail(String username, String email);

    public AppUser findByVerificationTokenToken(String token);
}
