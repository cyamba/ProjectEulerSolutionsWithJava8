package com.yambacode.solutions.euler49;

import com.yambacode.common.util.NumberStringConversions;
import com.yambacode.solutions.AbstractEulerSolver;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

import static com.yambacode.math.Primes.generatePrimes;
import static java.util.stream.Collectors.groupingBy;

/**
 * TODO DO
 * http://projecteuler.net/problem=49
 * <p/>
 * Created by cbyamba on 2014-02-03.
 */
public class Euler49 extends AbstractEulerSolver {

    public static final long[] PRIMES = generatePrimes(1000, 9999);

    @Override
    public String doSolve() {
        Map<Long, List<PrimePermutation>> map = LongStream.of(PRIMES)
                .mapToObj(p -> NumberStringConversions.longToLongArray(p))
                .map(a -> new PrimePermutation(a)).collect(groupingBy(PrimePermutation::getAsLong));

        return Arrays.toString(map.entrySet().toArray());
    }


}
