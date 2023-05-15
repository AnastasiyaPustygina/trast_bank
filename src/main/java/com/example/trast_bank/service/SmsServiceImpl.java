package com.example.trast_bank.service;

import com.example.trast_bank.domain.Sms;
import com.example.trast_bank.repository.SmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService{
    private final SmsRepository smsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Sms> findByUserId(long id) {
        return smsRepository.findByUserId(id);
    }

    @Override
    @Transactional
    public Sms save(Sms sms) {
        return smsRepository.save(sms);
    }
}
