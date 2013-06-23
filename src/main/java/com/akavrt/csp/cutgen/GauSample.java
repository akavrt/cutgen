package com.akavrt.csp.cutgen;

import com.akavrt.csp.Order;
import com.akavrt.csp.Problem;

/**
 * User: akavrt
 * Date: 24.06.13
 * Time: 01:34
 */
public class GauSample {

    public static void main(String[] args) {
        ProblemDescriptors descriptors = new ProblemDescriptors(10, 1000, 0.375, 0.625, 50);

        PseudoRandom rGen = new PseudoRandom(1994);
        ProblemGenerator pGen = new ProblemGenerator(rGen, descriptors);

        for (int i = 0; i < 150; i++) {
            Problem problem = pGen.nextProblem();

            if (i == 0 || i == 149) {
                printProblem(problem);
            }
        }
    }

    private static void printProblem(Problem problem) {
        System.out.println("*** PROBLEM ***");
        for (int i = 0; i < problem.size(); i++) {
            Order order = problem.getOrder(i);
            System.out.println(String.format("Order #%2d: l_i = %3d  d_i = %2d",
                                             i + 1, order.getLength(), order.getQuantity()));

        }
    }

}
