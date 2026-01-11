package com.learning.kafka.common.dto;

import java.time.LocalDateTime;

public record OrderCreatedEvent(
        String orderId,
        String userId,
        double amount,
        LocalDateTime createdAt
) {}
