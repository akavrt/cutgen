package com.akavrt.csp;

/**
 * <p>Order definition used in classical 1D-CSP with length and demand specified as integers.</p>
 *
 * @author Victor Balabanov <akavrt@gmail.com>
 */
public class Order {
    private final int length;
    private final int demand;

    public Order(int length, int demand) {
        this.length = length;
        this.demand = demand;
    }

    public int getLength() {
        return length;
    }

    public int getDemand() {
        return demand;
    }
}