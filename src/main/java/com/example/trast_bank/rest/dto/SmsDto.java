package com.example.trast_bank.rest.dto;

import com.example.trast_bank.domain.Sms;
import com.example.trast_bank.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsDto {
    private final long id;
    private final String text;
    private final String info;

    public static Sms toDomainObject(SmsDto smsDto, User user){
        return Sms.builder().id(smsDto.getId()).text(smsDto.getText()).info(smsDto.getInfo()).user(user).build();
    }
    public static SmsDto toDto(Sms sms){
        return SmsDto.builder().id(sms.getId()).text(sms.getText()).info(sms.getInfo()).build();
    }
}
