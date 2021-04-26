package com.team10.banchan.model;

import org.springframework.data.annotation.Id;

public class Order {
    @Id
    private final Long id;
    private final Long itemId;
    private final Integer quantity;

    Order(Long id, Long itemId, Integer quantity) {
        this.id = id;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public static Order newOrder(Long itemId, Integer quantity) {
        return new Order(null, itemId, quantity);
    }
}
