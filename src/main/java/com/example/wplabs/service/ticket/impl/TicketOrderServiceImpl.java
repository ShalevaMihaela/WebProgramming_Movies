package com.example.wplabs.service.ticket.impl;

import com.example.wplabs.entity.TicketOrderEntity;
import com.example.wplabs.repository.ShoppingCartRepository;
import com.example.wplabs.repository.TicketOrderRepository;
import com.example.wplabs.repository.UserRepository;
import com.example.wplabs.service.ticket.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;
    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public TicketOrderServiceImpl(TicketOrderRepository ticketOrderRepository, UserRepository userRepository, ShoppingCartRepository shoppingCartRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public TicketOrderEntity placeOrder(String movieTitle, int numberOfTickets) {
        return ticketOrderRepository.save(new TicketOrderEntity(movieTitle, (long) numberOfTickets));
    }
}
