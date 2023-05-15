package com.example.trast_bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "users")
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "phone")
    private String phone;
    @Column(name = "date_expiration")
    private String dateExpiration;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Sms> smsList;
}
