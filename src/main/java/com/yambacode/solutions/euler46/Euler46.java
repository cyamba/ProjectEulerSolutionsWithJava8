package com.yambacode.solutions.euler46;

import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;

import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-01-25.
 */
public class Euler46 extends AbstractEulerSolver {

    private long[] generateSquares(long max) {
        return LongStream.range(1, max).map(x -> x * x).toArray();
    }

    private long[] generatePrimes(long max) {
        return Primes.generatePrimes(max);
    }

    public long[] generateGoldbachNumbers(long max) {
        int m = (int) max;
        long[] goldbachs = new long[m * m];
        long[] squares = generateSquares(max);
        long[] primes = generatePrimes(max);
        for (int i = 0; i < primes.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                goldbachs[i + j] = primes[i] + 2 * squares[j];
            }
        }
        return LongStream.of(goldbachs).distinct().toArray();
    }

    public Long find(long[] goldbachs) {
        for (int i = 0; i < goldbachs.length - 1; i++) {
            if (goldbachs[i] - goldbachs[i + 1] > 2) {
                return goldbachs[i] + 2;
            }
        }
        return null;
    }


    @Override
    public String doSolve() {
        return "" + find(generatePrimes(25000l));
    }

    public static void main(String...args){
        new Euler46().solve();
    }
}
