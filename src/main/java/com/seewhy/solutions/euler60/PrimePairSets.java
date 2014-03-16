package com.seewhy.solutions.euler60;

import static com.seewhy.math.Primes.*;
import static com.seewhy.math.Sets.*;

import com.seewhy.math.SetsExperiment;
import com.seewhy.solutions.AbstractEulerSolver;

import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * http://projecteuler.net/problem=60
 * <p/>
 * Created by cbyamba on 2014-02-07.
 */
public class PrimePairSets extends AbstractEulerSolver {

    public boolean isPrimePairSet(TreeSet<Integer> set) {
        List<Integer> origSet = IntStream.range(0, set.size()).parallel().boxed().collect(toList());
        return subsetsOfSizeTwo(origSet).parallelStream().allMatch(pair -> isPrimePair(pair, origSet));
    }

    private Integer concatenate(Integer x, Integer y) {
        return Integer.valueOf(x.toString() + y.toString());
    }

    private boolean isPrimePair(TreeSet<Integer> pair, List<Integer> origSet) {
        List<Integer> pairAsList = pair.stream().collect(toList());
        Integer x = pairAsList.get(0);
        Integer y = pairAsList.get(1);
        return arePrimes(
                concatenate(x, y), concatenate(y, x)
        );
    }

    @Override
    public String doSolve() {
        List<Integer> primes = LongStream.of(generatePrimesByCount(800))
                .parallel()
                .boxed()
                .mapToInt(x -> Integer.valueOf(x.toString()))
                .boxed()
                .collect(toList());


        return "" +
                // subsetsFixedSize(primes, 4) //TODO optimize subsetsFixedSize
                SetsExperiment.subsetsOfFourElements(primes)
                        .parallelStream()
                        .filter(set -> isPrimePairSet(set))
                        .map(set -> set.stream().mapToInt(x -> (int) x).sum())
                        .sorted()
                        .findFirst()
                        .get();
    }

    public static void main(String... args) {
        new PrimePairSets().solve();
    }
}
