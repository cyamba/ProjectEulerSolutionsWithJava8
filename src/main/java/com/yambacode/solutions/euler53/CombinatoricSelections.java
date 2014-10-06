package com.yambacode.solutions.euler53;

import com.yambacode.solutions.AbstractEulerSolver;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.yambacode.math.combinatorics.Combinatorics.combinations;

/**
 * http://projecteuler.net/problem=53
 * <p/>
 * Created by cbyamba on 2014-02-05.
 */
public class CombinatoricSelections extends AbstractEulerSolver {


    public List<BigInteger> selections(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(r -> combinations(n, r))
                .collect(Collectors.toList());
    }

    @Override
    public String doSolve() {
        return "" + IntStream.rangeClosed(1, 100)
                .mapToObj(n -> n).flatMap(n -> selections(n).stream())
                .filter(b -> b.compareTo(BigInteger.valueOf(1000000L)) > 0)
                .count();
    }

    public static void main(String... args) {
        new CombinatoricSelections().solve();
    }
}
