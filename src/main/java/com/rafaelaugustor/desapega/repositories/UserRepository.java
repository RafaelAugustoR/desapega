package com.rafaelaugustor.desapega.repositories;

import com.rafaelaugustor.desapega.domain.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query(
            """
            UPDATE User u SET u.password = ?2 WHERE u.email = ?1
            """
    )
    void updatePassword(String email, String password);
}
