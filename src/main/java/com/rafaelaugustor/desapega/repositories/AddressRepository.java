package com.rafaelaugustor.desapega.repositories;

import com.rafaelaugustor.desapega.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
