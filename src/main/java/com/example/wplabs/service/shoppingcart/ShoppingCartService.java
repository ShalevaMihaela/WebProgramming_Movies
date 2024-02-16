package com.example.wplabs.service.shoppingcart;

import com.example.wplabs.entity.ShoppingCartEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ShoppingCartService {

    void addMoviesToShoppingCart(List<String> movieTitles, List<Integer> numberOfTickets, String username, LocalDateTime dateCreated);

    List<ShoppingCartEntity> filterOrders(LocalDate from, LocalDate to, String username);
}
