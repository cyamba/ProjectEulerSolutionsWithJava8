package com.yambacode.solutions.euler49;

import com.yambacode.solutions.AbstractEulerSolver;

import java.util.Collection;
import java.util.stream.LongStream;

import static com.yambacode.common.util.NumberStringConversions.longToLongArray;
import static com.yambacode.common.util.UpDownCastArrays.upCast;
import static com.yambacode.math.combinatorics.Permutations.generatePermutationCollection;
import static com.yambacode.math.Primes.generatePrimes;
import static java.util.stream.LongStream.of;

/**
 * TODO DO
 * http://projecteuler.net/problem=49
 * <p/>
 * Created by cbyamba on 2014-01-25.
 */
public class Euler49LambdaVersion extends AbstractEulerSolver {


    public long numberWithSortedDigits(Long number) {
        long[] digits = of(longToLongArray(number)).toArray();
        String sortedNumberStr = of(digits).sorted().mapToObj(d -> String.valueOf(d)).reduce((s1, s2) -> s1 + s2).get();
        return Long.valueOf(sortedNumberStr);

    }

    //TODO take a number and return an array of all permutations of that number in increasing order.
    //filter out all non primes in the list of permutations.
    //

    //TODO refactor with boxed (box a long[] to a Long[])

    public Collection<Comparable[]> groupingBy(Long[] digits) {
        return generatePermutationCollection(digits);
    }

    public Long[] toSortedDigits(Long number) {
        return upCast(LongStream.of(longToLongArray(number)).sorted().toArray());
    }

    @Override
    public String doSolve() {
        long[] primes = generatePrimes(1000, 9999);

        // Long[] a = LongStream.of(primes).map(p -> numberWithSortedDigits(p)).sorted().filter(x -> x > 999).boxed().toArray(x -> new Long[993]);
        //Map<Collection<Comparable[]>, List<PrimePermutation>> primePermutationMap = of(primes).mapToObj(x -> toSortedDigits(x));
        //.map(PrimePermutation::new)
        // .collect(Collectors.groupingBy(PrimePermutation::getPermutations));
        return "";
        //Arrays.toString(primePermutationMap.values().toArray());

    }
}
