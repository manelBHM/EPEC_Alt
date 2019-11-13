package com.Ecommerce.dao;

import com.Ecommerce.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    public VerificationToken findByUserEmail(String email);
    public VerificationToken findByToken(String token);
}
