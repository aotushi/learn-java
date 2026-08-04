package com.aotushi.learnjava.orderadmin.order;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long id) {
        super("找不到订单：" + id);
    }
}
