package com.yambacode.solutions.euler34;

import com.yambacode.math.Combinatorics;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2011-12-10.
 */
public class SumOfFactorialDigits extends AbstractEulerSolver {

    private static BigInteger UPPER_LIMIT = Combinatorics.factorial(9).multiply(BigInteger.valueOf(8L));

    public Number compute() {
        BigInteger sum = BigInteger.ZERO;
        BigInteger i = BigInteger.valueOf(3L);
        while (i.compareTo(UPPER_LIMIT) < 0) {
            if (isDigitalRootOfFactorial(i)) {
                sum = sum.add(i);
            }
            i = i.add(BigInteger.ONE);
        }
        return sum;
    }

    private boolean isDigitalRootOfFactorial(BigInteger number) {
        int count = 0;
        BigInteger sum = BigInteger.ZERO;
        while (count < number.toString().length()) {
            sum = sum.add(Combinatorics.factorial(Integer.parseInt(number.toString().substring(count, count + 1))));
            count++;
        }
        return sum.equals(number);
    }

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new SumOfFactorialDigits());
    }
}
