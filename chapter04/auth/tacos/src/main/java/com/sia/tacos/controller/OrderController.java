package com.sia.tacos.controller;

import com.sia.tacos.domain.Order;
import com.sia.tacos.repository.OrderRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public String orderForm() {
        return "orderForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processOrder(@ModelAttribute Order order, SessionStatus sessionStatus) {
        orderRepository.save(order);

        sessionStatus.setComplete();

        return "redirect:/";
    }
}
