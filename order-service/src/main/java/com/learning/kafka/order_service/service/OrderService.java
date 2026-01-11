package com.learning.kafka.order_service.service;

import com.learning.kafka.common.dto.OrderCreatedEvent;

public interface OrderService {

    void orderPublish(OrderCreatedEvent orderCreateEvent);
}
