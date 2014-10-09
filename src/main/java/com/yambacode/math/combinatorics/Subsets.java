package com.yambacode.math.combinatorics;

import static com.yambacode.math.YMath.log;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-10-05.
 */
public class Subsets {

    /**
     * @param size   - number of elements of the set
     * @param number - the number to be converted to a subset.
     * @return
     */
    public static int[] toSubset(int size, int number) {
        if (size < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        if (log(number, 2) > size) {
            throw new IllegalArgumentException("number is too big");
        }
        int[] subset = new int[Integer.bitCount(number)];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (((number >>> i) & 1) == 1) {
                subset[j++] = i;
            }
        }
        return subset;
    }

    /**
     * @param length
     * @return
     */
    public static int[][] subsets(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        int size = BigInteger.valueOf(2).pow(length).intValue();
        return IntStream.range(0, size)
                .mapToObj(i -> toSubset(length, i))
                .toArray(int[][]::new);
    }


}
