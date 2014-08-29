package com.yambacode.solutions.euler58;

import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-03-06.
 */
public class PrimeSpiral extends AbstractEulerSolver {

    /**
     * 5  4  3
     * 6  1  2
     * 7  8  9
     * <p/>
     * <p/>
     * NORTH-EAST : (2n)^2+1          ne(1) = 5
     * NORTH-WEST : (2n)^2-2n+1       nw(1) = 3
     * SOUTH-WEST : (2n+1)^2          se(1) = 9
     * SOUTH-EAST : (2n)^2+2n+1       se(1) = 7
     *
     * @return
     */
    @Override
    public String doSolve() {
//        long[] longs = LongStream
//                .rangeClosed(1, 100)
//                .parallel()
//                .flatMap(this::spiralDiagonal)
//                .filter(Primes::isPrime)
//                .toArray();
//        LongStream.rangeClosed(1, 100)
//                .parallel();

        double[] doubles = LongStream.rangeClosed(1, 100)
                .parallel()
                .mapToDouble(this::fromNToPercent)
                .toArray();

        return Arrays.toString(doubles);
    }

    protected LongStream spiralDiagonal(long n) {
        return LongStream.of(nw(n), ne(n), sw(n), sw(n));
    }

    protected double fromNToPercent(long n) {
        long primeCount = spiralDiagonal(n).filter(Primes::isPrime).count();
        return percentOfPrimes(primeCount, n);
    }

    /**
     * length is 2n+1
     * total is (2n+1)^2
     *
     * @param primeCount
     * @param n
     * @return
     */
    protected double percentOfPrimes(long primeCount, long n) {
        return ((double) primeCount) / ((double) total(n));
    }

    /**
     * 5  4  3
     * 6  1  2
     * 7  8  9
     * @param n
     * @return
     */
    protected long total(long n) {
        return se(n);
    }

    protected long se(long n) {
        return (2 * n + 1) * (2 * n + 1);
    }

    protected long ne(long n) {
        return 4 * n * n - 2 * n + 1;
    }

    protected long nw(long n) {
        return 4 * n * n + 1;
    }

    protected long sw(long n) {
        return 4 * n * n + 2 * n + 1;
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PrimeSpiral());
    }
}
