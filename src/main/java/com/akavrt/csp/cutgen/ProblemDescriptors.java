package com.akavrt.csp.cutgen;

/**
 * User: akavrt
 * Date: 24.06.13
 * Time: 00:41
 */
public class ProblemDescriptors {
    private final int size;
    private final int stockLength;
    private final double orderLengthLowerBound;
    private final double orderLengthUpperBound;
    private final int averageDemand;

    public ProblemDescriptors(int size, int stockLength,
                              double orderLengthLowerBound, double orderLengthUpperBound,
                              int averageDemand) {
        this.size = size;
        this.stockLength = stockLength;
        this.orderLengthLowerBound = orderLengthLowerBound;
        this.orderLengthUpperBound = orderLengthUpperBound;
        this.averageDemand = averageDemand;
    }

    public int getSize() {
        return size;
    }

    public int getStockLength() {
        return stockLength;
    }

    public double getOrderLengthLowerBound() {
        return orderLengthLowerBound;
    }

    public double getOrderLengthUpperBound() {
        return orderLengthUpperBound;
    }

    public int getAverageDemand() {
        return averageDemand;
    }
}
