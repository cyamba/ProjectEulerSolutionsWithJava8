package com.yambacode.math.combinatorics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-10-05.
 */
public class Subsets {

    public static int[] toSubset(int length, int number) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        if (BigInteger.valueOf(number).compareTo(BigInteger.valueOf(2).pow(length)) > 0) {
            throw new IllegalArgumentException("number is to big");
        }
        int[] subset = new int[Integer.bitCount(number)];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (((number >>> i) & 1) == 1) {
                subset[j++] = i;
            }
        }
        return subset;
    }

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
