package com.learning.kafka.order_service.service;

import com.learning.kafka.common.dto.OrderCreatedEvent;

public interface OrderProducer {
    void publish(OrderCreatedEvent orderCreateEvent);
}
