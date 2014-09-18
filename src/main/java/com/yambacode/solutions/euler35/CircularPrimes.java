package com.yambacode.solutions.euler35;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2011-12-03
 */
public class CircularPrimes extends AbstractEulerSolver {

    private static final int CERTAINTY = 20;

    public Number compute() {
        int nbrOfCircularPrimes = 0;
        BigInteger prime = BigInteger.valueOf(1L);
        while (prime.compareTo(BigInteger.valueOf(1000000L)) < 0) {
            nbrOfCircularPrimes += (isCircular(prime = prime.nextProbablePrime(), 0, true)) ? 1 : 0;
        }
        return nbrOfCircularPrimes;
    }

    private Boolean isCircular(BigInteger prime, int count, boolean isPrime) {
        String s = prime.toString();
        if (!isPrime) return false;
        return (count == s.length()) ?
                true :
                isCircular(prime = new BigInteger(new StringBuilder()
                                .append(s.substring(s.length() - 1, s.length()))
                                .append(s.substring(0, s.length() - 1))
                                .toString()),
                        ++count,
                        prime.isProbablePrime(CERTAINTY)
                );

    }

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CircularPrimes());
    }
}
