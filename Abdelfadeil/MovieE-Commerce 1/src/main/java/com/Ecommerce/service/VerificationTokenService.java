package com.Ecommerce.service;

import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.dao.VerificationTokenRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class VerificationTokenService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private SendingMailService sendingMailService;


    public void createVerification(String email) {
        AppUser user = userRepository.findByEmail(email);
        if (user.equals(null)) {
            return;
        } else {
                VerificationToken token = new VerificationToken();
                token.setUser(user);
                verificationTokenRepository.save(token);
                sendingMailService.sendVerificationMail(email, token.getToken());
        }
    }

    public ResponseEntity<String> verifyEmail(String token){
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken.equals(null)) {
            return ResponseEntity.badRequest().body("Invalid token.");
        }
        if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
            return ResponseEntity.unprocessableEntity().body("Expired token.");
        }
        verificationToken.setConfirmedDateTime(LocalDateTime.now());
        verificationToken.setStatus(VerificationToken.STATUS_VERIFIED);
        verificationToken.getUser().setIsActive(true);
        verificationTokenRepository.save(verificationToken);
        return ResponseEntity.ok("You have successfully verified your email address.");
    }

}
