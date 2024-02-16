package com.example.wplabs.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Convert(converter = UserFullNameConverter.class)
    private UserFullName userFullName;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @OneToMany
    private List<ShoppingCartEntity> carts = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(String username, UserFullName userFullName, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.userFullName = userFullName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserFullName getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(UserFullName userFullName) {
        this.userFullName = userFullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<ShoppingCartEntity> getCarts() {
        return carts;
    }

    public void setCarts(List<ShoppingCartEntity> carts) {
        this.carts = carts;
    }
}
