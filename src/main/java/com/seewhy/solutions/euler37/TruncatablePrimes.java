package com.seewhy.solutions.euler37;

import com.seewhy.solutions.AbstractEulerSolver;

import static com.seewhy.math.Primes.isPrime;
import static java.util.stream.LongStream.of;
import static java.util.stream.LongStream.range;

/**
 * <link>http://projecteuler.net/problem=37<link/>
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
 * left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * <p/>
 * Answer:748317
 * Created by cbyamba on 2014-01-17.
 */
public class TruncatablePrimes extends AbstractEulerSolver {

    public long[] generateTruncatables(long number) {
        String numberStr = String.valueOf(number);
        return parseDigits(numberStr);

    }

    private long[] parseDigits(String numberStr) {
        int length = numberStr.length();
        long[] result = new long[2 * length];
        for (int i = 0; i < length; i++) {
            result[i] = Long.valueOf(numberStr.substring(0, i + 1));
            result[i + length] = Long.valueOf(numberStr.substring(i));
        }
        return result;
    }

    public boolean isTruncatablePrime(long prime) {
        long[] truncatables = generateTruncatables(prime);
        return of(truncatables).allMatch(x -> isPrime(x));

    }

    @Override
    public String doSolve() {
        return "" + range(10, 1000000l).filter(x -> isPrime(x)).filter(x -> isTruncatablePrime(x)).sum();
    }
}
