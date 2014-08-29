package com.yambacode.experiments;

import com.yambacode.common.io.Printer;

import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-02-10.
 */
public class ImperativeFunctionalEquivalence {

    public static final int SIZE = 10000;

    public static long nestedFor() {
        long sum = 0;
        for (int i = 2; i <= SIZE; i++) {
            for (int j = 1; j < i; j++) {
                sum += i + j;
                //System.out.print(String.format("%s+%s -> sum : %s , ", i, j, sum));
            }
        }
        return sum;
    }

    public static long mapFlatMap() {
        return LongStream.rangeClosed(1, SIZE).parallel()
                .map(i -> LongStream.range(1, i)
                        .map(x -> x + i)
                                //  .peek(x -> System.out.print(x + " "))
                        .sum())
                .sum();
    }

    /**
     * Note for mutable operations performance is not as good in the functional case
     * @param args
     */
    public static void main(String... args) {

        long start = System.currentTimeMillis();
        long imperative = nestedFor();
        long imperativeTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        long functional = mapFlatMap();
        long functionalTime = System.currentTimeMillis() - start;

        Printer.print(String.format("imperative case = %s, time : %s ms, functional case = %s, time : %s ms",
                imperative, imperativeTime, functional, functionalTime));
    }
}
