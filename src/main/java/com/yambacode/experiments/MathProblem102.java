package com.yambacode.experiments;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import static com.yambacode.common.util.NumberStringConversions.comparableArrayToLong;
import static com.yambacode.common.util.NumberStringConversions.longToComparableArray;
import static com.yambacode.math.Permutations.generatePermutationCollection;
import static com.yambacode.math.Primes.generatePrimesAsList;
import static com.yambacode.math.Primes.isPrime;
import static java.util.stream.Collectors.joining;

/**
 * Created by cbyamba on 2014-03-12.
 */
public class MathProblem102 extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return generatePrimesAsList(10000)
                .parallelStream()
                .filter(this::isAbsolutePrime)
                .map(p -> p.toString())
                .collect(joining(", "));
    }

    protected boolean isAbsolutePrime(Long number) {
        return generatePermutationCollection(longToComparableArray(number))
                .parallelStream()
                .allMatch(arr -> isPrime(comparableArrayToLong(arr)));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblem102());
    }
}
