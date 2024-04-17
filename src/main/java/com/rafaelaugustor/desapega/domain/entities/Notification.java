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
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Instant date;

    @Column(nullable = false)
    private Boolean isViewed;

    @ManyToOne
    private User senderSolicitation;

    @ManyToOne
    private User receiverSolicitation;
}
