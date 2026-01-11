package com.learning.kafka.order_service.dto;

import java.time.LocalDateTime;

public record OrderCreateEvent(String orderId,
                               String userId,
                               double amount,
                               LocalDateTime  createAt) {
}
