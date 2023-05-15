package com.example.trast_bank.rest.dto;

import com.example.trast_bank.domain.Sms;
import com.example.trast_bank.domain.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {
    private final long id;
    private final String phone;
    private final String cardNumber;
    private final String date_expiration;

    private final List<SmsDto> smsDtos;

    public static User toDomainObject(UserDto userDto, List<Sms> smsList) {
        return User.builder().id(userDto.getId()).phone(userDto.getPhone()).cardNumber(userDto.getCardNumber())
                .dateExpiration(userDto.getDate_expiration()).smsList(smsList).build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder().id(user.getId()).phone(user.getPhone()).cardNumber(user.getCardNumber())
                .date_expiration(user.getDateExpiration()).smsDtos(user.getSmsList().stream()
                        .map(SmsDto::toDto).toList()).build();
    }

}
