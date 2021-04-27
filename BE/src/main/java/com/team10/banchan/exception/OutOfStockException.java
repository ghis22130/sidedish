package com.team10.banchan.exception;

public class OutOfStockException extends RuntimeException {
    private final Integer currentStock;
    public OutOfStockException(String message, Integer currentStock) {
        super(message);
        this.currentStock = currentStock;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }
}
