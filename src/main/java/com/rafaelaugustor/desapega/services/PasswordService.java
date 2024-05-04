package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.broker.producers.EmailProducer;
import com.rafaelaugustor.desapega.domain.entities.ForgotPassword;
import com.rafaelaugustor.desapega.domain.entities.User;
import com.rafaelaugustor.desapega.repositories.ForgotPasswordRepository;
import com.rafaelaugustor.desapega.repositories.UserRepository;
import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.RecoveryPasswordRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class PasswordService {


    private final UserRepository userRepository;

    private final ForgotPasswordRepository forgotPasswordRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailProducer producer;

    public void verifyEmail(String email){
        User user = userRepository.findByEmail(email);

        Random random = new Random();

        int otp = random.nextInt(100_000, 999_999);

        EmailRequestDTO recoveryPasswordEmail = EmailRequestDTO.builder()
                .to(email)
                .subject("OTP - Recovery password")
                .text("This is your OTP for your Recovery Password request: " + otp)
                .build();

        ForgotPassword fp = ForgotPassword.builder()
                .otp(otp)
                .expirationTime(Instant.now().plusSeconds(300))
                .user(user)
                .build();

        producer.sendConfirmationEmail(recoveryPasswordEmail);
        forgotPasswordRepository.save(fp);
    }

    public void verifyOtp(Integer otp, String email){
        User user = userRepository.findByEmail(email);

        ForgotPassword fp = forgotPasswordRepository.findByOtpAndUser(otp, user)
                .orElseThrow(() -> new RuntimeException("Invalid OTP for email" + email));

        if (isOtpExpired(fp)) {
            forgotPasswordRepository.deleteById(fp.getId());
            log.info("OTP FOR {} has been expired", user.getEmail());
        }

    }

    private boolean isOtpExpired(ForgotPassword fp) {
        return fp.getExpirationTime().isBefore(Instant.now());
    }

    public void changePassword(RecoveryPasswordRequestDTO request, String email){

        if(!request.getPassword().equals(request.getConfirmPassword())){
            throw new RuntimeException("Password don´t matches");
        }

        userRepository.updatePassword(email, passwordEncoder.encode(request.getPassword()));

    }


}
