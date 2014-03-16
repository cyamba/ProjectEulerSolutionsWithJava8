package com.seewhy.solutions.euler10;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;

import static com.seewhy.math.Primes.isPrime;
import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
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
