package com.yambacode.solutions.euler31;

import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class SimpleGeneratingFunctionCoefficient extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        return compute().toString();
    }

    private static final int POWER = 10;
    private static final int LENGTH = 2;

    public Number compute() {

        long coefficent = 0;
        for (long i = 1; i <= Math.pow(POWER, LENGTH); i++) {
            coefficent += compute(i);
        }
        return coefficent;
    }

    private Long compute(Long i) {
        return (long) (
                ((i / Math.pow(POWER, LENGTH - 1) + 1) +
                        (i % (POWER + 1))) == POWER ?
                        1 :
                        0);
    }


    public static void main(String... a) {
        throw new UnsupportedOperationException("Finish me!");
    }
}
