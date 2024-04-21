package com.rafaelaugustor.desapega.repositories;

import com.rafaelaugustor.desapega.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmail(String email);
}
