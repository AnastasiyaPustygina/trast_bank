package com.example.trast_bank.rest.controller;

import com.example.trast_bank.rest.dto.SmsDto;
import com.example.trast_bank.service.SmsService;
import com.example.trast_bank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;
    private final UserService userService;

    @GetMapping(path = "/sms/{id}")
    public List<SmsDto> findByUserId(@PathVariable(name = "user_id") long userId){
        return smsService.findByUserId(userId).stream().map(SmsDto::toDto).toList();
    }

    @PostMapping(path = "/sms" )
    public SmsDto save(@RequestBody SmsDto smsDto, @RequestParam(name = "user_id") long userId){
        return SmsDto.toDto(smsService.save(SmsDto.toDomainObject(smsDto, userService.findById(userId))));
    }
}
