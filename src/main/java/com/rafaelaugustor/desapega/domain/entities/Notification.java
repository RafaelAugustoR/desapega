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

    private String message;

    private Instant date;

    private Boolean isViewed;

    @ManyToOne
    private User senderSolicitation;

    @ManyToOne
    private User receiverSolicitation;
}
