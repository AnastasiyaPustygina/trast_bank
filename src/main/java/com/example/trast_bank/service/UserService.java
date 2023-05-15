package com.example.trast_bank.service;

import com.example.trast_bank.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void deleteById(long id);

    List<User> findAll();

    User findByCardNumber(String cardNumber);

    User findByPhone(String phone);
    User findById(long id);

}
