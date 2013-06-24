package com.akavrt.csp.cutgen;

/**
 * <p>Gau and Wascher (1995) introduced five descriptors which could be used to define specific,
 * homogeneous classes of problem instances for 1D SSSCSP.</p>
 *
 * <p>For more detailed explanation refer to the original EJOR paper:</p>
 *
 * <p>Gau, T., and Wascher, G., 1995, CUTGEN1 - a problem generator for the one-dimensional
 * cutting stock problem. European Journal of Operational Research, 84, 572-579.</p>
 *
 * @author Victor Balabanov <akavrt@gmail.com>
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

    /**
     * <p>Size of the given instance of 1D SSSCSP is defined as the number of different order
     * lengths.</p>
     *
     * <p>In notation taken by Gau and Wascher (1995): m.</p>
     *
     * @return Size of the problem.
     */
    public int getSize() {
        return size;
    }

    /**
     * <p>Standard size of the stock items available in an unlimited supply.</p>
     *
     * <p>In notation taken by Gau and Wascher (1995): L.</p>
     *
     * @return Size of the stock items, specified by an integer number.
     */
    public int getStockLength() {
        return stockLength;
    }

    /**
     * <p>Lower bound for the relative size of order lengths in relation to the standard size of
     * the stock items.</p>
     *
     * <p>In notation taken by Gau and Wascher (1995): v_1.</p>
     *
     * <p>l_i >= v_1 * L for all i = 1, ..., m, where l_i - length of the i-th order.</p>
     *
     * @return Lower bound for the relative size of order lengths specified as a fractional ratio.
     */
    public double getOrderLengthLowerBound() {
        return orderLengthLowerBound;
    }

    /**
     * <p>Upper bound for the relative size of order lengths in relation to the standard size of
     * the stock items.</p>
     *
     * <p>In notation taken by Gau and Wascher (1995): v_2.</p>
     *
     * <p>l_i <= v_2 * L for all i = 1, ..., m, where l_i - length of the i-th order.</p>
     *
     * <p>0 < v_1 < v_2 <= 1.</p>
     *
     * @return Upper bound for the relative size of order lengths specified as a fractional ratio.
     */
    public double getOrderLengthUpperBound() {
        return orderLengthUpperBound;
    }

    /**
     * <p>Average demand per order length.</p>
     *
     * <p>In notation taken by Gau and Wascher (1995): d.</p>
     *
     * <p>Total demand distributed between the different orders is D = m * d.</p>
     *
     * @return Average demand per order length.
     */
    public int getAverageDemand() {
        return averageDemand;
    }
}
