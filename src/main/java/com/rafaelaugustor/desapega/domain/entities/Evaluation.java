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
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(precision = 1, scale = 1, nullable = false)
    private Double rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Instant date;

    @ManyToOne
    private User evaluatingUser;

    @ManyToOne
    private User evaluatedUser;
}