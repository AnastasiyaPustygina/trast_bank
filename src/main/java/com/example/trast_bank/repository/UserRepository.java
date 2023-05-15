package com.example.trast_bank.repository;

import com.example.trast_bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCardNumber(String cardNumber);
    Optional<User> findByPhone(String phone);
}
