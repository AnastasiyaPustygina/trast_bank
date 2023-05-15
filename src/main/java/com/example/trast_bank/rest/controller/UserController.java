package com.example.trast_bank.rest.controller;

import com.example.trast_bank.domain.User;
import com.example.trast_bank.rest.dto.UserDto;
import com.example.trast_bank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/users")
    public List<UserDto> findAll(){
        return userService.findAll().stream().map(UserDto::toDto).toList();
    }

    @GetMapping(path = "/user/cardNumber/{cardNumber}")
    public UserDto findByCardNumber(@PathVariable String cardNumber){
        return UserDto.toDto(userService.findByCardNumber(cardNumber));
    }

    @GetMapping(path = "/user/phone/{phone}")
    public UserDto findByPhone(@PathVariable String phone){
        return UserDto.toDto(userService.findByPhone(phone));
    }

    @PostMapping(path = "/user" )
    public UserDto save(@RequestBody UserDto userDto){
        return UserDto.toDto(userService.save(UserDto.toDomainObject(userDto, Collections.emptyList())));
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteById(@PathVariable long id){
        userService.deleteById(id);
    }

}
