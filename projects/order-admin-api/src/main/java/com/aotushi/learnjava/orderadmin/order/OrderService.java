package com.aotushi.learnjava.orderadmin.order;

import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final AtomicLong sequence = new AtomicLong();
    private final Map<Long, Order> orders = new ConcurrentHashMap<>();
    private final Clock clock;

    public OrderService() {
        this(Clock.systemUTC());
    }

    OrderService(Clock clock) {
        this.clock = clock;
    }

    public Order create(String customerName, List<OrderLine> lines) {
        long id = sequence.incrementAndGet();
        long totalMinor = lines.stream()
                .mapToLong(OrderLine::subtotalMinor)
                .reduce(0L, Math::addExact);

        var order = new Order(
                id,
                "ORD-%06d".formatted(id),
                customerName.strip(),
                lines,
                totalMinor,
                OrderStatus.CREATED,
                Instant.now(clock)
        );
        orders.put(id, order);
        return order;
    }

    public Order find(long id) {
        var order = orders.get(id);
        if (order == null) {
            throw new OrderNotFoundException(id);
        }
        return order;
    }

    public List<Order> findAll() {
        return orders.values().stream()
                .sorted(Comparator.comparingLong(Order::id))
                .toList();
    }
}
