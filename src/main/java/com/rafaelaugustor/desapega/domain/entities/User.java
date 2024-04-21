package com.rafaelaugustor.desapega.domain.entities;

import com.rafaelaugustor.desapega.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "\"USER\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 10, nullable = false)
    private LocalDate birthDate;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(length = 80, nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String profilePicture;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @OneToMany(mappedBy = "sender")
    private List<Chat> messagesSent;

    @OneToMany(mappedBy = "receiver")
    private List<Chat> messagesReceived;

    @OneToMany(mappedBy = "evaluatedUser")
    private List<Evaluation> evaluationsReceived;

    @OneToMany(mappedBy = "evaluatingUser")
    private List<Evaluation> evaluationsMade;

    @OneToMany(mappedBy = "requester")
    private List<Transaction> transactionsRequested;

    @OneToMany(mappedBy = "requestedUser")
    private List<Transaction> transactionsReceived;

    @OneToMany(mappedBy = "receiverSolicitation")
    private List<Notification> receivedNotifications;

    @OneToMany(mappedBy = "senderSolicitation")
    private List<Notification> sentNotifications;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}