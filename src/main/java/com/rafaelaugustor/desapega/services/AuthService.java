package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.domain.entities.Address;
import com.rafaelaugustor.desapega.domain.entities.ForgotPassword;
import com.rafaelaugustor.desapega.domain.entities.User;
import com.rafaelaugustor.desapega.domain.enums.UserRole;
import com.rafaelaugustor.desapega.repositories.AddressRepository;
import com.rafaelaugustor.desapega.repositories.ForgotPasswordRepository;
import com.rafaelaugustor.desapega.repositories.UserRepository;
import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.LoginRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.RegisterRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final ForgotPasswordRepository forgotPasswordRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public LoginResponseDTO login(LoginRequestDTO request){
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return LoginResponseDTO.builder()
                .token(token)
                .build();
    }

    public void register(RegisterRequestDTO request){

        Address userAddress = Address.builder()
                .country(request.getAddress().getCountry())
                .city(request.getAddress().getCity())
                .state(request.getAddress().getState())
                .neighborhood(request.getAddress().getNeighborhood())
                .street(request.getAddress().getStreet())
                .postalCode(request.getAddress().getPostalCode())
                .houseNumber(request.getAddress().getHouseNumber())
                .complement(request.getAddress().getComplement())
                .build();

        addressRepository.save(userAddress);

        if (!request.getPassword().equals(request.getConfirmPassword())){
            throw new RuntimeException();
        }

        User userToSave = User.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .birthDate(request.getBirthDate())
                .address(userAddress)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.CUSTOMER)
                .build();

        userRepository.save(userToSave);
    }

    public void verifyEmail(String email){
        User user = userRepository.findByEmail(email);

        Random random = new Random();

        int otp = random.nextInt(100_000, 999_999);

        EmailRequestDTO request = EmailRequestDTO.builder()
                .to(email)
                .subject("OTP - Recovery password")
                .text("This is your OTP for your Recovery Password request" + otp)
                .build();

        ForgotPassword fp = ForgotPassword.builder()
                .otp(otp)
                .expirationTime(new Date(System.currentTimeMillis() + 70 * 1000))
                .user(user)
                .build();

        emailService.simpleMailMessage(request);
        forgotPasswordRepository.save(fp);
    }

}
