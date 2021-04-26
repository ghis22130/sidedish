package com.team10.banchan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutOfOrderInfo {
    private final Integer currentStock;

    private OutOfOrderInfo(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public static OutOfOrderInfo of(Integer currentStock) {
        return new OutOfOrderInfo(currentStock);
    }

    @JsonProperty("current_stock")
    public Integer getCurrentStock() {
        return currentStock;
    }
}
