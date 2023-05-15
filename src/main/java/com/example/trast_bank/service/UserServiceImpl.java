package com.example.trast_bank.service;

import com.example.trast_bank.domain.User;
import com.example.trast_bank.exception.UserAlreadyExistsException;
import com.example.trast_bank.exception.UserNotFoundException;
import com.example.trast_bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User save(User user) {
        if(userRepository.findByCardNumber(user.getCardNumber()).isPresent() &&
                userRepository.findByCardNumber(user.getCardNumber()).get().getPhone().equals(user.getPhone())){
            throw new UserAlreadyExistsException("user with card number " + user.getCardNumber()
                    + " and phone " + user.getPhone() + " already exists");
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        if(userRepository.findById(id).isPresent()){
            throw new UserNotFoundException("no user with id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByCardNumber(String cardNumber) {
        return userRepository.findByCardNumber(cardNumber).orElseThrow(() -> new UserNotFoundException(
                "no user with card number " + cardNumber));
    }

    @Override
    @Transactional(readOnly = true)
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone).orElseThrow(() -> new UserNotFoundException(
                "no user with phone " + phone));
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "no user with id " + id));
    }
}
