package com.example.wplabs.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity user;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;

    @OneToMany
    private List<TicketOrderEntity> ticketOrders = new ArrayList<>();

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(UserEntity user, LocalDateTime dateCreated) {
        this.user = user;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<TicketOrderEntity> getTicketOrders() {
        return ticketOrders;
    }

    public void setTicketOrders(List<TicketOrderEntity> ticketOrders) {
        this.ticketOrders = ticketOrders;
    }
}
