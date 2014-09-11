package com.yambacode.solutions.euler46;


import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.math.FigurativeNumbers.nextOddComposite;
import static com.yambacode.math.Primes.isPrime;
import static java.util.stream.LongStream.of;
import static java.util.stream.LongStream.rangeClosed;

/**
 * http://projecteuler.net/problem=46
 * <p/>
 * Created by cbyamba on 2014-01-25.
 */
public class GoldbachsOtherConjecture extends AbstractEulerSolver {

    public boolean hasLinearCombination(long x) {
        long[] squares = rangeClosed(1, (long) Math.ceil(Math.sqrt(x))).map(i -> i * i).toArray();
        return of(squares)
                .anyMatch(i -> isPrime(x - 2 * i));
    }

    @Override
    public String doSolve() {
        Long x = 9l;
        while (hasLinearCombination(x)) {
            x = nextOddComposite(x);
        }
        return x.toString();
    }

    public static void main(String... args) {
        new GoldbachsOtherConjecture().solve();
    }

}
