package com.akavrt.csp;

/**
 * <p>Order definition used in classical 1D-CSP with length and demand specified as integers.</p>
 *
 * @author Victor Balabanov <akavrt@gmail.com>
 */
public class Order {
    private final long length;
    private final long quantity;

    public Order(long length, long quantity) {
        this.length = length;
        this.quantity = quantity;
    }

    public long getLength() {
        return length;
    }

    public long getQuantity() {
        return quantity;
    }
}