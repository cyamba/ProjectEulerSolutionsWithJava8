package com.yambacode.solutions.euler43;

import static com.yambacode.math.Primes.*;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.common.util.NumberStringConversions.comparableArrayToLong;
import static com.yambacode.common.util.NumberStringConversions.intArrayToInt;
import static com.yambacode.math.combinatorics.Permutations.generatePermutationCollection;
import static java.util.Arrays.copyOfRange;
import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-24.
 */
public class SubstringDivisibility extends AbstractEulerSolver {

    private static final int SIZE = 10;

    private static final Comparable[] permutation = rangeClosed(0, SIZE - 1)
            .boxed()
            .toArray(x -> new Integer[SIZE]);

    public boolean isDivisible(Comparable[] permutation) {
        long[] primes = generatePrimesClosed(1, 17);
        for (int i = 1; i < permutation.length - 2; i++) {
            Comparable[] partialNumber = copyOfRange(permutation, i, i + 3);
            int[] digits = of(partialNumber).mapToInt(x -> Integer.valueOf(x.toString())).toArray();
            if ((intArrayToInt(digits)) % primes[i - 1] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String doSolve() {
        return "" + generatePermutationCollection(permutation)
                .stream()
                .filter(x -> isDivisible(x))
                .mapToLong(x -> comparableArrayToLong(x))
                .sum();
    }
}
