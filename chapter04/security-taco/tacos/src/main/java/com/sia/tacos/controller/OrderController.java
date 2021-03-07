package com.sia.tacos.controller;

import com.sia.tacos.domain.Order;
import com.sia.tacos.domain.User;
import com.sia.tacos.repository.OrderRepository;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @RequestMapping(value = "current", method = RequestMethod.GET)
    public String showOrderForm(@AuthenticationPrincipal User user, @ModelAttribute Order order) {

        if (order.getDeliveryName() == null) {
            order.setDeliveryName(user.getFullname());
        }

        if (order.getDeliveryStreet() == null) {
            order.setDeliveryStreet(user.getStreet());
        }

        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(user.getCity());
        }

        if (order.getDeliveryState() == null) {
            order.setDeliveryState(user.getState());
        }

        if (order.getDeliveryZip() == null) {
            order.setDeliveryZip(user.getZip());
        }

        return "orderForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processOrder(@ModelAttribute Order order, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {

        order.setUser(user);

        orderRepository.save(order);

        sessionStatus.setComplete();

        return "redirect:/";
    }

}
