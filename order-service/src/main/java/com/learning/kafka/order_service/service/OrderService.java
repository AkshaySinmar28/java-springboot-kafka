package com.learning.kafka.order_service.service;

import com.learning.kafka.order_service.dto.OrderCreateEvent;

public interface OrderService {

    void orderPublish(OrderCreateEvent orderCreateEvent);
}
