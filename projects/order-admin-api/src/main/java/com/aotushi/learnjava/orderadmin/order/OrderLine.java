package com.aotushi.learnjava.orderadmin.order;

public record OrderLine(String sku, long unitPriceMinor, int quantity) {
    public OrderLine {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU 不能为空。");
        }
        if (unitPriceMinor < 0) {
            throw new IllegalArgumentException("商品价格不能为负数。");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("商品数量必须至少为 1。");
        }
    }

    public long subtotalMinor() {
        return Math.multiplyExact(unitPriceMinor, quantity);
    }
}
