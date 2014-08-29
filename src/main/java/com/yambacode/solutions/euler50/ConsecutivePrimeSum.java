package com.yambacode.solutions.euler50;

import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.of;

/**
 * http://projecteuler.net/problem=50
 * TODO IMPROVE! current solution takes about 110183 ms
 * Created by cbyamba on 2014-02-01.
 */
public class ConsecutivePrimeSum extends AbstractEulerSolver {

    private static final List<Integer> primes = of(Primes.generatePrimesFast(1000000)).boxed().collect(toList());

    public Integer numberOfConsecutivePrimes(int indexOfPrime) {
        Integer max = 0;
        Integer nextIndexOfPrime = indexOfPrime;
        --nextIndexOfPrime;
        while (nextIndexOfPrime >= 0) {
            Integer count = numberOfConsecutivePrimes(indexOfPrime, nextIndexOfPrime);
            if (count != null && count > max) {
                max = count;
            }
            nextIndexOfPrime = --nextIndexOfPrime;
        }
        return max;
    }

    private Integer nextPrimeDown(int indexOfPrime) {
        return (indexOfPrime - 1 >= 0) ? primes.get(indexOfPrime - 1) : null;
    }

    //TODO use the generated primes to getNextDown primes. Caching
    public Integer numberOfConsecutivePrimes(int indexOfPrime, int indexOfStartPrime) {
        Integer nextPrime = primes.get(indexOfStartPrime);
        int total = primes.get(indexOfPrime);
        int maxCount = 0;
        while (nextPrime != null) {
            total -= nextPrime;
            maxCount++;
            if (total == 0) {
                return maxCount;
            }
            if (total < 0) {
                return null;
            }
            nextPrime = nextPrimeDown(indexOfStartPrime);
            indexOfStartPrime--;
        }
        return null;
    }

    public static void main(String... args) {
        new ConsecutivePrimeSum().solve();
    }

    @Override
    public String doSolve() {
        return primes
                .parallelStream()
                .reduce((x, y) -> (numberOfConsecutivePrimes(primes.indexOf(x)) > numberOfConsecutivePrimes(primes.indexOf(y))) ? x : y)
                .get().toString();
    }
}
