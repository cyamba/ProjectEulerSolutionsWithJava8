package com.yambacode.solutions.euler69;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;

import static com.yambacode.solutions.euler97.BigIntegers._1;
import static com.yambacode.solutions.euler97.BigIntegers._2;

/**
 * Created by cbyamba on 2014-08-27.
 */
public class TotientMaximum3 extends AbstractEulerSolver {

    public static long MAX = 1_000_000;


    @Override
    public String doSolve() {
        return findMaximum(BigInteger.valueOf(MAX)).toString();
    }

    BigInteger findMaximum(BigInteger max) {
        return findMaximum0(max, _2, _1, _1);
    }

    public BigInteger findMaximum0(BigInteger max, BigInteger prime,
                                   BigInteger product, BigInteger lastPrime) {
        if (product.compareTo(max) >= 0) {
            return product.divide(lastPrime);
        }
        return findMaximum0(max, prime.nextProbablePrime(), product.multiply(prime), prime);
    }


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new TotientMaximum3());
    }
}