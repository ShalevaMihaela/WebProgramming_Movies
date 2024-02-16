package com.example.wplabs.service.shoppingcart.impl;

import com.example.wplabs.entity.ShoppingCartEntity;
import com.example.wplabs.entity.TicketOrderEntity;
import com.example.wplabs.entity.UserEntity;
import com.example.wplabs.entity.UserFullName;
import com.example.wplabs.repository.ShoppingCartRepository;
import com.example.wplabs.repository.UserRepository;
import com.example.wplabs.service.movie.MovieService;
import com.example.wplabs.service.shoppingcart.ShoppingCartService;
import com.example.wplabs.service.ticket.TicketOrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final MovieService movieService;
    private final TicketOrderService ticketOrderService;

    public ShoppingCartServiceImpl(UserRepository userRepository, ShoppingCartRepository shoppingCartRepository, MovieService movieService, TicketOrderService ticketOrderService) {
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.movieService = movieService;
        this.ticketOrderService = ticketOrderService;
    }

    @Override
    public void addMoviesToShoppingCart(List<String> movieTitles, List<Integer> numberOfTickets, String username, LocalDateTime dateCreated) {
        Optional<UserEntity> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            ShoppingCartEntity shoppingCart = new ShoppingCartEntity(user.get(), dateCreated);
            for (int i = 0; i < movieTitles.size(); i++) {
                TicketOrderEntity ticketOrderEntity = ticketOrderService.placeOrder(movieTitles.get(i), numberOfTickets.get(i));
                shoppingCart.getTicketOrders().add(ticketOrderEntity);
            }

            shoppingCartRepository.save(shoppingCart);
        } else {

            UserEntity newUser = userRepository.save(new UserEntity(username, new UserFullName("Petko","Petkov"), "", LocalDate.now()));
            ShoppingCartEntity shoppingCart = new ShoppingCartEntity(newUser, dateCreated);
            for (int i = 0; i < movieTitles.size(); i++) {
                TicketOrderEntity ticketOrderEntity = ticketOrderService.placeOrder(movieTitles.get(i), numberOfTickets.get(i));
                shoppingCart.getTicketOrders().add(ticketOrderEntity);
            }
            shoppingCartRepository.save(shoppingCart);
        }
    }

    @Override
    public List<ShoppingCartEntity> filterOrders(LocalDate from, LocalDate to, String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);

        LocalDateTime fromDate = from.atStartOfDay();
        LocalDateTime toDate = to.atTime(LocalTime.MAX);
        return shoppingCartRepository.findAllByUserAndDateCreatedBetween(user.get(), fromDate, toDate);
    }


}
