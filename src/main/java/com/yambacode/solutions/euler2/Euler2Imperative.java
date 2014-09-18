package com.yambacode.solutions.euler2;

import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2011-11-06
 */
public class Euler2Imperative extends AbstractEulerSolver {

    private static final long UPPER = 4000000;

    @Override
    public String doSolve() {
        long fibb1 = 1;
        long fibb2 = 1;
        long sum = 0;
        while (fibb2 < UPPER) {
            long tmp = fibb2;
            fibb2 += fibb1;
            fibb1 = tmp;
            if (fibb2 % 2 == 0)
                sum += fibb2;
        }
        return "" + sum;
    }
}
