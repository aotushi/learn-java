package com.aotushi.learnjava.orderadmin.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateOrderLineRequest(
        @NotBlank String sku,
        @PositiveOrZero long unitPriceMinor,
        @Positive int quantity
) {
    public OrderLine toOrderLine() {
        return new OrderLine(sku, unitPriceMinor, quantity);
    }
}
