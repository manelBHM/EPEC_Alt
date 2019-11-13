package com.Ecommerce.service;

import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.dao.VerificationTokenRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.Ecommerce.entities.VerificationToken.STATUS_VERIFIED;

@Service
@Transactional
public class VerificationTokenService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private SendingMailService sendingMailService;


    public void createVerification(String email) {
        AppUser user = userRepository.findByEmail(email);
        if (user ==null) {
          return;
        }
                VerificationToken token = new VerificationToken();
        token= verificationTokenRepository.save(token);
                user.setVerificationToken(token);
                // token.setUser(user);
                userRepository.save(user);
                String text = "http://localhost:8080/confirmRegistration?username="+user.getUsername()+"&token="+token.getToken();
                sendingMailService.sendVerificationMail(email, text);

    }

    public AppUser verifyEmail(String token, String username) throws Exception {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        AppUser user= userRepository.findByUsername(username);

        if (verificationToken == null) throw new Exception("token null ! ");
        if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) throw new Exception("token expire ! ");

        verificationToken.setConfirmedDateTime(LocalDateTime.now());
        verificationToken.setStatus(STATUS_VERIFIED);
        user.setIsActive(true);
        user.setVerificationToken(verificationToken);
         verificationTokenRepository.save(verificationToken);
        return userRepository.save(user);
    }


}
