package com.akavrt.csp.cutgen;

import com.akavrt.csp.Order;
import com.akavrt.csp.Problem;

/**
 * User: akavrt
 * Date: 24.06.13
 * Time: 00:40
 */
public class ProblemGenerator {
    private final PseudoRandom rGen;
    private final ProblemDescriptors descriptors;

    public ProblemGenerator(PseudoRandom random, ProblemDescriptors descriptors) {
        this.rGen = random;
        this.descriptors = descriptors;
    }

    public Problem nextProblem() {
        int[] lengths = generateLengths();
        int[] demands = generateDemands();


        return merge(lengths, demands);
    }

    private int[] generateLengths() {
        int[] result = new int[descriptors.getSize()];

        double lb = descriptors.getOrderLengthLowerBound();
        double ub = descriptors.getOrderLengthUpperBound();
        for (int i = 0; i < 10; i++) {
            double rValue = rGen.nextDouble();
            double length = (lb + (ub - lb) * rValue) * descriptors.getStockLength() + rValue;

            result[i] = (int) length;
        }

        Utils.descendingSort(result);

        return result;
    }

    private int[] generateDemands() {
        int[] result = new int[descriptors.getSize()];

        double sum = 0;
        double[] rands = new double[descriptors.getSize()];
        for (int i = 0; i < result.length; i++) {
            rands[i] = rGen.nextDouble();
            sum += rands[i];
        }

        int totalDemand = descriptors.getAverageDemand() * descriptors.getSize();
        int rest = totalDemand;
        for (int i = 0; i < result.length - 1; i++) {
            double demand = totalDemand * rands[i] / sum + 0.5;
            result[i] = Math.max(1, (int) demand);

            rest -= result[i];
        }

        result[result.length - 1] = Math.max(1, rest);

        return result;
    }

    private Problem merge(int[] lengths, int[] demands) {
        Problem problem = new Problem(descriptors.getStockLength());
        for (int i = 0; i < lengths.length; i++) {
            if (i == lengths.length - 1 || lengths[i] != lengths[i + 1]) {
                Order order = new Order(lengths[i], demands[i]);
                problem.addOrder(order);
            } else {
                demands[i + 1] += demands[i];
            }
        }

        return problem;
    }

}
