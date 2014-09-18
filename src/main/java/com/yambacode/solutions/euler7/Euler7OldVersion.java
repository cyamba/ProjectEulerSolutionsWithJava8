package com.yambacode.solutions.euler7;

import com.yambacode.solutions.AbstractEulerSolver;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class Euler7OldVersion extends AbstractEulerSolver {

    private static final int N = 10001;

    @Override
    public String doSolve() {
        BigInteger number = BigInteger.valueOf((long) 2);
        int count = 1;
        while (count < N) {
            number = number.nextProbablePrime();
            if (number.isProbablePrime(9)) {
                count++;
            }
        }
        return number.toString();
    }
}
