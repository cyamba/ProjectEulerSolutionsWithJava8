package com.yambacode.solutions.euler10;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.math.Primes.isPrime;
import static java.util.stream.LongStream.range;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class SummationOfPrimes extends AbstractEulerSolver {

    public String doSolve() {
        return "" + range(1, 2000000)
                //.parallel()
                .filter(x -> isPrime(x))
                .sum();

    }

    public static void main(String... args) {
        Printer.print(new SummationOfPrimes().solve());
    }

}
