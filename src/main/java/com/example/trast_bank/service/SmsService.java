package com.example.trast_bank.service;

import com.example.trast_bank.domain.Sms;

import java.util.List;

public interface SmsService {
    List<Sms> findByUserId(long id);
    Sms save(Sms sms);
}
