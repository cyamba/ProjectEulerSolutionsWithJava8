package com.yambacode.solutions.euler48;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2011-12-03
 */
public class PerfectRisingHyperCubeSum extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return calculate().toString();
    }

    public Number calculate() {
        BigInteger sum = BigInteger.ZERO;
        for (long i = 1; i < 1000; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow((int) i));
        }
        return sum.mod(BigInteger.valueOf(10000000000L));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PerfectRisingHyperCubeSum());
    }
}
