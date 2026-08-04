package com.aotushi.learnjava.orderadmin.order;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderServiceTest {
    private final OrderService service = new OrderService(
            Clock.fixed(Instant.parse("2026-01-01T00:00:00Z"), ZoneOffset.UTC)
    );

    @Test
    void createsAnOrderWithAnExactTotal() {
        var order = service.create("Alice", List.of(
                new OrderLine("JAVA-BOOK", 9_900, 1),
                new OrderLine("USB-CABLE", 2_500, 2)
        ));

        assertThat(order.orderNumber()).isEqualTo("ORD-000001");
        assertThat(order.totalMinor()).isEqualTo(14_900);
        assertThat(order.status()).isEqualTo(OrderStatus.CREATED);
        assertThat(order.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
    }

    @Test
    void findsOrdersInCreationOrder() {
        service.create("Alice", List.of(new OrderLine("A", 100, 1)));
        service.create("Bob", List.of(new OrderLine("B", 200, 1)));

        assertThat(service.findAll())
                .extracting(Order::orderNumber)
                .containsExactly("ORD-000001", "ORD-000002");
    }

    @Test
    void reportsAMissingOrder() {
        assertThatThrownBy(() -> service.find(99))
                .isInstanceOf(OrderNotFoundException.class)
                .hasMessage("找不到订单：99");
    }

    @Test
    void rejectsAnInvalidLineItem() {
        assertThatThrownBy(() -> new OrderLine("JAVA-BOOK", -1, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("商品价格不能为负数。");
    }
}
