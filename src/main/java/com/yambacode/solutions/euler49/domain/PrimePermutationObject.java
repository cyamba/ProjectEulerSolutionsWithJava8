package com.yambacode.solutions.euler49.domain;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.common.util.NumberStringConversions.intArrayToInt;
import static com.yambacode.common.util.NumberStringConversions.intToIntArray;
import static com.yambacode.common.util.UpDownCastArrays.downCast;
import static com.yambacode.math.Primes.arePrimes;
import static java.util.stream.IntStream.of;
import static java.util.stream.Stream.of;

/**
 * http://projecteuler.net/problem=49
 * <p/>
 * Created by cbyamba on 2014-02-04.
 */
public class PrimePermutationObject extends AbstractEulerSolver {


    public boolean arePermutations(Integer... args) {
        return of(args).mapToInt(x -> toSortedDigitsInt(x)).allMatch(x -> x == toSortedDigitsInt(args[0]));
    }

    private int toSortedDigitsInt(Integer original) {
        return intArrayToInt(of(intToIntArray(original)).sorted().toArray());
    }

    public boolean arePrimePermutations(Integer... args) {
        return arePermutations(args) && arePrimes(downCast(args));
    }

    @Override
    public String doSolve() {
        //TODO flat map

        StringBuilder result = new StringBuilder();
        for (int original = 1488; original < 9999; original++) {
            for (int increment = 2; original + 2 * increment <= 9999; increment++) {
                int newOne = original + increment;
                int lastOne = newOne + increment;
                if (arePrimePermutations(original, newOne, lastOne)) {
                    return "" + original + "" + newOne + "" + lastOne;
                }

            }
        }
        return result.toString();
    }

    public static void main(String... args) {
        new PrimePermutationObject().solve();
    }

}
