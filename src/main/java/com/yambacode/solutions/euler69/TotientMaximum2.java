package com.yambacode.solutions.euler69;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.stream.LongStream;

import static com.yambacode.math.Divisibility.totient;

/**
 * Created by cbyamba on 2014-08-27.
 */
public class TotientMaximum2 extends AbstractEulerSolver {

    //private static final int MAX = 1_000_000;
    private static final int MAX = 1_000_000;

    @Override
    public String doSolve() {
        return "" + LongStream.range(2, MAX).parallel().reduce((n, max) -> totientRatio(n) > totientRatio(max) ? n : max).getAsLong();
    }

    public double totientRatio(long n) {
        return ((double) n) / ((double) totient(n));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new TotientMaximum2());
    }
}
