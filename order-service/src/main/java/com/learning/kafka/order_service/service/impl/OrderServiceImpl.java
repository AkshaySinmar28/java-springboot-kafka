package com.learning.kafka.order_service.service.impl;

import com.learning.kafka.order_service.dto.OrderCreateEvent;
import com.learning.kafka.order_service.service.OrderProducer;
import com.learning.kafka.order_service.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    OrderProducer orderProducer;

    public OrderServiceImpl(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @Override
    public void orderPublish(OrderCreateEvent orderCreateEvent) {
        orderProducer.publish(orderCreateEvent);
    }
}
