package com.rafaelaugustor.desapega.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Instant date;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;
}
