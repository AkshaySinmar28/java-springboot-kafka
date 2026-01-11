package com.learning.kafka.order_service.controller;

import com.learning.kafka.common.dto.OrderCreatedEvent;
import com.learning.kafka.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestParam double amount) {
        OrderCreatedEvent orderCreateEvent = new OrderCreatedEvent(UUID.randomUUID().toString(), "1", amount, LocalDateTime.now());
        orderService.orderPublish(orderCreateEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body("order created successfully");
    }
}
