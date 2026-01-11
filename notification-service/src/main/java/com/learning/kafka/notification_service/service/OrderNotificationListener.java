package com.learning.kafka.notification_service.service;

import com.learning.kafka.common.dto.OrderCreatedEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationListener {
    @KafkaListener(topics = "order-events",groupId = "notification_group")
    public void handleOrderEvent(
            ConsumerRecord<String, OrderCreatedEvent> record, Acknowledgment acknowledgment
    ){
        OrderCreatedEvent orderCreatedEvent = record.value();
        try {
            IO.println(orderCreatedEvent.toString());
            IO.println(orderCreatedEvent.amount());
            IO.println(orderCreatedEvent.orderId());
            processNotification(orderCreatedEvent);
        acknowledgment.acknowledge();
            IO.println("Offset committed for order: "+ orderCreatedEvent.orderId());

    } catch (Exception e) {
            IO.println("Failed to ProcessOrder: "+ orderCreatedEvent.orderId());
            throw e;
        }
    }
   private void  processNotification(OrderCreatedEvent orderCreatedEvent){
        if(Math.random() < 0.3){
            throw new RuntimeException("Email service down");
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }
        IO.println("Notification sent for order: "+ orderCreatedEvent.orderId());
    }
}
