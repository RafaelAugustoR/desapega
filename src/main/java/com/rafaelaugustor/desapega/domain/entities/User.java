package com.rafaelaugustor.desapega.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "\"USER\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

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

    @Column(nullable = false)
    private String profilePicture;

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
}