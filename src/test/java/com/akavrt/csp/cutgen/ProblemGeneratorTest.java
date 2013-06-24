package com.akavrt.csp.cutgen;

import com.akavrt.csp.Order;
import com.akavrt.csp.Problem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <p>Test data is obtained from Gau and Wascher (1995), p. 576:</p>
 *
 * <p>Gau, T., and Wascher, G., 1995, CUTGEN1 - a problem generator for the one-dimensional
 * cutting stock problem. European Journal of Operational Research, 84, 572-579.</p>
 */
public class ProblemGeneratorTest {

    @Test
    public void ejorSample() {
        // in the original EJOR paper authors provide two problem
        // instances generated using CUTGEN1 with specific seed
        // and a given set of problem descriptors:
        // seed = 1994
        // m = 10, L = 1000, v_1 = 0.375, v_2 = 0.625, d = 50

        ProblemDescriptors descriptors = new ProblemDescriptors(10, 1000, 0.375, 0.625, 50);

        PseudoRandom rGen = new PseudoRandom(1994);
        ProblemGenerator pGen = new ProblemGenerator(rGen, descriptors);

        // this is the first one from 150 problem instances to be generated
        Problem firstActual = pGen.nextProblem();
        Problem firstExpected = setupFirstProblem(descriptors.getStockLength());
        assertProblemEquality(firstExpected, firstActual);

        for (int i = 2; i <= 149; i++) {
            pGen.nextProblem();
        }

        // this is the last one from 150 generated problem instances
        Problem lastActual = pGen.nextProblem();
        Problem lastExpected = setupLastProblem(descriptors.getStockLength());
        assertProblemEquality(lastExpected, lastActual);
    }

    private Problem setupFirstProblem(int stockLength) {
        Problem expected = new Problem(stockLength);
        expected.addOrder(new Order(577, 63));
        expected.addOrder(new Order(570, 64));
        expected.addOrder(new Order(544, 85));
        expected.addOrder(new Order(539, 84));
        expected.addOrder(new Order(526, 54));
        expected.addOrder(new Order(512, 20));
        expected.addOrder(new Order(504, 24));
        expected.addOrder(new Order(459, 31));
        expected.addOrder(new Order(446, 48));
        expected.addOrder(new Order(378, 27));

        return expected;
    }

    private Problem setupLastProblem(int stockLength) {
        Problem expected = new Problem(stockLength);
        expected.addOrder(new Order(570, 16));
        expected.addOrder(new Order(558, 94));
        expected.addOrder(new Order(543, 20));
        expected.addOrder(new Order(540, 99));
        expected.addOrder(new Order(513, 59));
        expected.addOrder(new Order(490, 48));
        expected.addOrder(new Order(476, 78));
        expected.addOrder(new Order(453, 35));
        expected.addOrder(new Order(434, 51));

        return expected;
    }

    private void assertProblemEquality(Problem expected, Problem actual) {
        assertTrue(actual != null);

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.getStockLength(), actual.getStockLength());

        for (int i = 0; i < expected.size(); i++) {
            Order expectedOrder = expected.getOrder(i);
            Order actualOrder = actual.getOrder(i);

            assertEquals(expectedOrder.getLength(), actualOrder.getLength());
            assertEquals(expectedOrder.getDemand(), actualOrder.getDemand());
        }
    }
}
