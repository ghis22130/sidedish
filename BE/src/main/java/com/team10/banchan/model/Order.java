package com.team10.banchan.model;

import org.springframework.data.annotation.Id;

public class Order {
    @Id
    private final Long id;
    private final Long item;
    private final Integer quantity;

    Order(Long id, Long item, Integer quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public static Order newOrder(Long item, Integer quantity) {
        return new Order(null, item, quantity);
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
