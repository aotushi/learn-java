package com.aotushi.learnjava.orderadmin.order;

import java.time.Instant;
import java.util.List;

public record Order(
        long id,
        String orderNumber,
        String customerName,
        List<OrderLine> lines,
        long totalMinor,
        OrderStatus status,
        Instant createdAt
) {
    public Order {
        lines = List.copyOf(lines);
    }
}
