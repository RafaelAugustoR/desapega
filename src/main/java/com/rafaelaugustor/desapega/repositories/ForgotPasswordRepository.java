package com.rafaelaugustor.desapega.repositories;

import com.rafaelaugustor.desapega.domain.entities.ForgotPassword;
import com.rafaelaugustor.desapega.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, UUID> {

    @Query(
            """
                    SELECT fp FROM ForgotPassword fp WHERE fp.otp = ?1 AND fp.user = ?2
                    """
    )
    Optional<ForgotPassword> findByOtpAndUser(Integer otp, User user);
}
