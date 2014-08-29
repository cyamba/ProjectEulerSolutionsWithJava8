package com.yambacode.solutions.euler3;

import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2014-01-10.
 */
public class LargestPrimeFactorLazyVersion extends AbstractEulerSolver {

    private static long INPUT_VALUE = 600851475143l;
    //private static long INPUT_VALUE = 13195l;


    @Override
    public String doSolve() {
        long n = (long) Math.sqrt(INPUT_VALUE);
        n = (n % 2 != 0) ? n : n + 1;
        for (; n > 2; n -= 2) {
            if (INPUT_VALUE % n == 0) {
                if (Primes.isPrime(n)) {
                    return String.valueOf(n);
                }
            }
        }
        return "";
    }

}
