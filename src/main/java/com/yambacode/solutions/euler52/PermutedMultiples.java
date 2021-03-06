package com.yambacode.solutions.euler52;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.math.combinatorics.Permutations.arePermutations;
import static java.util.stream.LongStream.range;
import static java.util.stream.LongStream.rangeClosed;

/**
 * http://projecteuler.net/problem=52
 * <p/>
 * Created by cbyamba on 2014-02-05.
 */
public class PermutedMultiples extends AbstractEulerSolver {

    public boolean hasPermutedMuliples(Long number) {
        return arePermutations(
                rangeClosed(1, 6)
                        .map(k -> k * number)
                        .boxed()
                        .toArray(x -> new Long[6])
        );

    }

    @Override
    public String doSolve() {
        return "" + range(10, 1000000)
                .parallel()
                .filter(x -> hasPermutedMuliples(x))
                .findFirst()
                .getAsLong();
    }

    public static void main(String... args) {
        new PermutedMultiples().solve();
    }
}
