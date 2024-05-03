package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.domain.entities.Address;
import com.rafaelaugustor.desapega.domain.entities.User;
import com.rafaelaugustor.desapega.domain.enums.UserRole;
import com.rafaelaugustor.desapega.domain.enums.UserStatus;
import com.rafaelaugustor.desapega.repositories.AddressRepository;
import com.rafaelaugustor.desapega.repositories.UserRepository;
import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.LoginRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.RegisterRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final EmailService emailService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public LoginResponseDTO login(LoginRequestDTO request){
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        User user = (User) auth.getPrincipal();
        if (user.getStatus() != UserStatus.ACTIVE) {
            throw new RuntimeException("User account is pending confirmation. Please confirm your email to activate your account.");
        }

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
            throw new RuntimeException("Password don't matches");
        }

        User userToSave = User.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .birthDate(request.getBirthDate())
                .address(userAddress)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.CUSTOMER)
                .status(UserStatus.PENDING)
                .build();

        userRepository.save(userToSave);

        EmailRequestDTO confirmUserEmail = EmailRequestDTO.builder()
                .to(request.getEmail())
                .subject("Desapega - confirm your email")
                .text("This is the link to confirm your email and complete your registration! https://desapega.com.br/confirm-email/" + request.getEmail().toLowerCase())
                .build();
        emailService.sendEmail(confirmUserEmail);
    }

    public void confirmEmail(String email){

        User user = userRepository.findByEmail(email);
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);

    }

}
