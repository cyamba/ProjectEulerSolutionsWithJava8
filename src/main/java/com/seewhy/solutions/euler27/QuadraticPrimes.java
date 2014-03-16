package com.seewhy.solutions.euler27;
import com.seewhy.math.Primes;
import com.seewhy.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2014-01-15.
 */
public class QuadraticPrimes extends AbstractEulerSolver {

    private static final int SIZE = 1000;

    public static int nbrOfGeneratedPrimes(int a, int b) {
        int n = 0;
        while (Primes.isPrime(quadraticFormula(n, a, b))) {
            n++;
        }
        return n;
    }

    public static int quadraticFormula(int n, int a, int b) {
        return n * n + a * n + b;
    }

    @Override
    public String doSolve() {
        Integer aFind = null;
        Integer bFind = null;
        int max = -2 * SIZE;
        for (int a = -SIZE + 1; a < SIZE; a++) {
            for (int b = -SIZE + 1; b < SIZE; b++) {
                int newMax = nbrOfGeneratedPrimes(a, b);
                if (newMax > max) {
                    max = newMax;
                    aFind = a;
                    bFind = b;
                }
            }
        }
        return String.valueOf(aFind * bFind);
    }
}
