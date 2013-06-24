package com.akavrt.csp.cutgen;

/**
 * <p>To ensure reproducibility of the problem instances generated with CUTGEN1, Gau and Wascher
 * (1995) implemented custom portable random number generator.</p>
 *
 * <p>This is a direct port to Java of the original pseudorandom number generator written in
 * Fortran. The source code for the latter one is available at ESICUP
 * <a href="http://paginas.fe.up.pt/~esicup">website</a>.</p>
 *
 * <p>For more detailed explanation refer to the original EJOR paper:</p>
 *
 * <p>Gau, T., and Wascher, G., 1995, CUTGEN1 - a problem generator for the one-dimensional
 * cutting stock problem. European Journal of Operational Research, 84, 572-579.</p>
 *
 * @author Victor Balabanov <akavrt@gmail.com>
 */
public class PseudoRandom {
    private static final int DEFAULT_SEED = 2013;
    private final static int IA = 16807;
    private final static int IM = 2147483647;
    private final static int IQ = 127773;
    private final static int IR = 2836;
    private int seed;

    /**
     * <p>Initializes an instance of the random number generator with default seed.</p>
     *
     * <p>As a default seed the number 2013 has been chosen.</p>
     */
    public PseudoRandom() {
        this(DEFAULT_SEED);
    }

    /**
     * <p>Initializes an instance of the random number generator with specific seed.</p>
     */
    public PseudoRandom(int seed) {
        this.seed = seed;
    }

    /**
     * <p><Returns the next pseudorandom, uniformly distributed double value between 0.0
     * (exclusive) and 1.0 (exclusive) from this random number generator's sequence.</p>
     *
     * @return The next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from
     *         this random number generator's sequence.
     */
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
