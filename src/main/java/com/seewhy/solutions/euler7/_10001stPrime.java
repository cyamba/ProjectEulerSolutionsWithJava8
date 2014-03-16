package com.seewhy.solutions.euler7;

import com.seewhy.solutions.AbstractEulerSolver;

import static com.seewhy.math.Primes.isPrime;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class _10001stPrime extends AbstractEulerSolver {


    //104743
    @Override
    public String doSolve() {
        int count = 2;
        long i = 3;
        Long primeNbr = null;
        while (count <= 10003) {
            if (isPrime(i)) {
                count++;
                primeNbr = Long.valueOf(i);
            }
            i += 2;
        }
        return primeNbr.toString();
    }
}
