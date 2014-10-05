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

    public static List<Integer> toSubset(int length, int number) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        if (BigInteger.valueOf(number).compareTo(BigInteger.valueOf(2).pow(length)) > 0) {
            throw new IllegalArgumentException("number is to big");
        }
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (((number >>> i) & 1) == 1) {
                subset.add(i);
            }
        }
        return subset;
    }

    public static List<List<Integer>> subsets(int length) {
        return IntStream.range(0, BigInteger.valueOf(2).pow(length).intValue())
                .mapToObj(i -> toSubset(length, i))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(toSubset(4, 15).toArray()));
        System.out.println(Arrays.deepToString(subsets(4).toArray()));
    }
}
