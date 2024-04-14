package com.rafaelaugustor.desapega.domain.entities;

import com.rafaelaugustor.desapega.domain.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private Instant date;

    private TransactionStatus status;

    @ManyToOne
    private User requester;

    @ManyToOne
    private User requestedUser;
}
