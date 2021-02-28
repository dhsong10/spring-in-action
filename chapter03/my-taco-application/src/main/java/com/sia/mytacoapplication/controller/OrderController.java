package com.sia.mytacoapplication.controller;

import com.sia.mytacoapplication.domain.Order;
import com.sia.mytacoapplication.repository.OrderRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/orders")
@SessionAttributes("order")
public class OrderController {
    
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;

    }
    
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public String orderForm() {

        return "orderForm";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String processOrser(Order order) {

        log.info(order.toString());

        orderRepository.save(order);

        return "redirect:/";

    }
}
