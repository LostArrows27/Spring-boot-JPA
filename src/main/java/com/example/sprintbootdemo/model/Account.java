package com.example.sprintbootdemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.example.sprintbootdemo.model.Enum.AccountRole;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String displayName;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccountRole role;
    private String fullName;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private Boolean gender;
    private String avatarUrl;
    private Boolean isActivated = true;
    // One-to-Many relationship with RefreshToken
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<RefreshToken> refreshTokens;
    // One-to-Many relationship with ShoppingCart
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<ShoppingCart> shoppingCarts;
    // One-to-Many relationship with Order
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<Order> orders;
}

