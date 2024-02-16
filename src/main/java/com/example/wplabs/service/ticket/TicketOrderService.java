package com.example.wplabs.service.ticket;

import com.example.wplabs.entity.ShoppingCartEntity;
import com.example.wplabs.entity.TicketOrderEntity;

import java.time.LocalDate;
import java.util.List;

public interface TicketOrderService {

    TicketOrderEntity placeOrder(String movieTitle, int numberOfTickets);


}
