package com.rafaelaugustor.desapega.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String name;

    private LocalDate birthDate;

    private String password;

    private String email;

    private String address;

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
    private List<Evaluation> evaluationsMade;}
