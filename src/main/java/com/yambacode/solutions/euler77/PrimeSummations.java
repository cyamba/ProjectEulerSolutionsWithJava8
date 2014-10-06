package com.yambacode.solutions.euler77;

import com.yambacode.solutions.AbstractEulerSolver;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static com.yambacode.math.Primes.generatePrimesAsList;
import static com.yambacode.math.combinatorics.Sets.subsets;
import static com.yambacode.solutions.EulerRunner.runEulerSolvers;
import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-02-18.
 */
public class PrimeSummations extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        Set<TreeSet<Integer>> subsets = subsets(generatePrimesAsList(10l)
                .parallelStream()
                .mapToInt(x -> Integer.valueOf(x.toString()))
                .boxed()
                .collect(toList()));
        return Arrays.toString(subsets.parallelStream().toArray());
    }

    public static void main(String... args) {
        runEulerSolvers(new PrimeSummations());
    }
}
