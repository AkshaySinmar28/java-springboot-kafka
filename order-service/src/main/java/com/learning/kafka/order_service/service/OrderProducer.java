package com.learning.kafka.order_service.service;

import com.learning.kafka.order_service.dto.OrderCreateEvent;

public interface OrderProducer {
    void publish(OrderCreateEvent orderCreateEvent);
}
