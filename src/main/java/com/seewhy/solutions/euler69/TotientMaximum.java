package com.seewhy.solutions.euler69;

import com.seewhy.solutions.AbstractEulerSolver;

import java.util.stream.LongStream;

import static com.seewhy.math.Divisibility.totient;

/**
 * Created by cbyamba on 2014-02-13.
 */
public class TotientMaximum extends AbstractEulerSolver {

    public static final long MAX = 10;

    public static Double nDividedByTotient(long n) {
        return (double) n / (double) totient(n);
    }

    public static Double nDividedByTotientFTA(long n) {
        return (double) n / (double) totient(n);
    }

    public static AbstractEulerSolver getNonParallelVersion() {
        return new AbstractEulerSolver() {
            @Override
            public String doSolve() {
                return "" + LongStream
                        .rangeClosed(1, MAX)
                        .map(n -> totient(n))
                        .reduce((maxCandidate, n) -> (nDividedByTotient(maxCandidate) > nDividedByTotient(n)) ? maxCandidate : n).getAsLong();
            }
        };
    }

    //TODO make inner for loop for calculating totient imperatively
    public static AbstractEulerSolver getImperativeVersion() {
        return new AbstractEulerSolver() {
            @Override
            public String doSolve() {
                Long maxIndex = 1l;
                for (long i = 2; i < MAX; i++) {
                    maxIndex = nDividedByTotient(i) > nDividedByTotient(maxIndex) ? i : maxIndex;
                }
                return maxIndex.toString();
            }
        };
    }

    @Override
    public String doSolve() {
        return "" + LongStream
                .rangeClosed(1, MAX)
                .map(n -> totient(n))
                .reduce((maxCandidate, n) -> (nDividedByTotient(maxCandidate) > nDividedByTotient(n)) ? maxCandidate : n)
                .getAsLong();
    }

    public static void main(String... args) {
        AbstractEulerSolver totientMaximumParallellVersion = getNonParallelVersion();
        // EulerRunner.runEulerSolvers(totientMaximumParallellVersion, getNonParallelVersion(), getImperativeVersion());
        totientMaximumParallellVersion.solve();
    }
}
