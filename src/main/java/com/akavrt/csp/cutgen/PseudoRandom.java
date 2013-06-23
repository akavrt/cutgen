package com.akavrt.csp.cutgen;

/**
 * User: akavrt
 * Date: 24.06.13
 * Time: 00:40
 */
public class PseudoRandom {
    private static final int DEFAULT_SEED = 2013;

    private final static int IA = 16807;
    private final static int IM = 2147483647;
    private final static int IQ = 127773;
    private final static int IR = 2836;

    private int seed;

    public PseudoRandom() {
        this(DEFAULT_SEED);
    }

    public PseudoRandom(int seed) {
        this.seed = seed;
    }

    public double nextDouble() {
        double am = 1d / IM;
        int k = seed / IQ;

        seed = IA * (seed - k * IQ) - IR * k;
        if (seed < 0) {
            seed += IM;
        }

        return am * seed;
    }
}
