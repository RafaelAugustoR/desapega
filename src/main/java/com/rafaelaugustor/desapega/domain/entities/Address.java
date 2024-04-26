package com.rafaelaugustor.desapega.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String country;

    private String city;

    private String state;

    private String neighborhood;

    private String street;

    private String postalCode;

    private Integer houseNumber;

    private String complement;

    @OneToOne(mappedBy = "address")
    private User user;
}
