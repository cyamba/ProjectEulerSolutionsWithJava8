package com.yambacode.solutions.euler1;

import static com.yambacode.math.Sums.arithmeticSum;

import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2012-06-20
 */
public class Euler1OldFastVersion extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        /**
         * By inclusion exclusion principle, deriving proper dividers counted once
         */
        int sumOf3multiples = 3 * arithmeticSum((int) Math.floor(999.0 / 3));
        int sumOf5multiples = 5 * arithmeticSum((int) Math.floor(999.0 / 5));
        int sumOfConjunction = 3 * 5 * arithmeticSum((int) Math.floor(999.0 / (3 * 5)));
        return "" + (sumOf3multiples + sumOf5multiples - sumOfConjunction);

    }
}
