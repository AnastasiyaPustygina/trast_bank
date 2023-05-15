package com.example.trast_bank.repository;

import com.example.trast_bank.domain.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmsRepository extends JpaRepository<Sms, Long> {
    List<Sms> findByUserId(long id);
}
