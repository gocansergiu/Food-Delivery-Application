package com.internship.accesa.fooddeliveryauthserver.repository;

import com.internship.accesa.fooddeliveryauthserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmailAndEmailVerified(String email, Boolean emailVerified);

    Optional<User> findOneByEmail(String email);

    Optional<User> findOneByConfirmationToken(String confirmationToken);
}
