package com.learning.kafka.order_service.service.impl;

import com.learning.kafka.common.dto.OrderCreatedEvent;
import com.learning.kafka.order_service.service.OrderProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerImpl implements OrderProducer {
    private static final String TOPIC = "order-events";
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderProducerImpl(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void publish(OrderCreatedEvent orderCreateEvent){
        kafkaTemplate.send(TOPIC,orderCreateEvent.orderId(),orderCreateEvent);
    }
}
