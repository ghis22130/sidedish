package com.team10.banchan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team10.banchan.model.Item;
import com.team10.banchan.model.Order;
import org.springframework.data.relational.core.sql.In;

public class OrderInfo {
    private final Long order;
    private final Long item;
    private final Integer quantity;
    private final String totalPrice;

    private OrderInfo(Long order, Long item, Integer quantity, String totalPrice) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static OrderInfo of(Order order, Item item) {
        Integer quantity = order.getQuantity();
        return new OrderInfo(order.getId(), item.getId(), quantity, item.calculateTotalPrice(quantity));
    }

    @JsonProperty("order_id")
    public Long getOrder() {
        return order;
    }

    @JsonProperty("item_id")
    public Long getItem() {
        return item;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("total_price")
    public String getTotalPrice() {
        return totalPrice;
    }
}
