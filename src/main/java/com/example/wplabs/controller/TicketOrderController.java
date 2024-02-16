package com.example.wplabs.controller;

import com.example.wplabs.service.shoppingcart.ShoppingCartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TicketOrderController {

    private final ShoppingCartService shoppingCartService;

    public TicketOrderController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/filterOrder")
    public String filterOrders(@RequestParam(name = "from") LocalDate from,
                               @RequestParam(name = "to") LocalDate to,
                               HttpServletRequest request,
                               Model model) {
        model.addAttribute("orders", shoppingCartService.filterOrders(from, to, request.getRemoteAddr()));
        return "listOrders";
    }

    @PostMapping("/order")
    public String orderTicket(@RequestParam(name = "movieTitle") List<String> movieTitle,
                              @RequestParam(name = "numTickets") List<Integer> numTickets,
                              @RequestParam(name = "dateAndTime") LocalDateTime dateAndTime,
                              HttpServletRequest request,
                              Model model) {

        shoppingCartService.addMoviesToShoppingCart(movieTitle, filterNullValues(numTickets), request.getRemoteAddr(), dateAndTime);
        model.addAttribute("ipAddress", request.getRemoteAddr());
        model.addAttribute("user", "Petko Petkov");
        model.addAttribute("movieTitles", movieTitle);
        model.addAttribute("numberOfTickets", filterNullValues(numTickets));

        return "orderConfirmation";
    }

    public List<Integer> filterNullValues(List<Integer> numberOfTickets) {
        List<Integer> filteredList = new ArrayList<>();

        for (Integer value : numberOfTickets) {
            if (value != null) {
                filteredList.add(value);
            }
        }

        return filteredList;
    }
}
