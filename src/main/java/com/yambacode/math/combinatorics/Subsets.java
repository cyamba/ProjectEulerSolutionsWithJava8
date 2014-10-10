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
        if (number < 0 || size < 0
                || log(number, 2) > size //number is too big
                ) {
            return new int[]{};
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
            return new int[][]{};
        }
        int size = BigInteger.valueOf(2).pow(length).intValue();
        return IntStream.range(0, size)
                .mapToObj(i -> toSubset(length, i))
                .toArray(int[][]::new);
    }


}
