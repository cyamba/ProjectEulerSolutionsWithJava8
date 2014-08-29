package com.yambacode.solutions.euler21;

import com.yambacode.solutions.AbstractEulerSolver;

import static java.util.stream.IntStream.range;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class AmicableNumbers extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + range(219, 285)
                .filter(x -> sumOfProperDivisors(x) == sumOfProperDivisors(sumOfProperDivisors(x)))
                .sum();
    }

    public static int sumOfProperDivisors(int n) {
        return range(1, n)
                .filter(x -> n % x == 0)
                .sum();
    }

    public static void main(String... args) {
        new AmicableNumbers().solve();
    }
}
