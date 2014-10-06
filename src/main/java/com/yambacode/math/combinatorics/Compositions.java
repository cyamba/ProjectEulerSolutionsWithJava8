package com.yambacode.math.combinatorics;

import com.yambacode.common.io.Printer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-10-05.
 */
public class Compositions {


    public static int[] toComposition(int length, int number) {
        if (length < 0 || number < 0) {
            throw new IllegalArgumentException("length and number must be non negative integers");
        }
        if (BigInteger.valueOf(number).compareTo(BigInteger.valueOf(2).pow(length)) > 0) {
            throw new IllegalArgumentException("number is too big");
        }
        int[] composition = new int[length - Integer.bitCount(number)];
        int i = 0;
        int j = 0;
        while (i < length) {
            Integer part = 1;
            while (((number >>> i) & 1) == 1) {
                part += 1;
                i++;
            }
            composition[j++] = part;
            i++;
        }
        return composition;
    }

    public static int[][] compositionsOf(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number must be non negative");
        }
        return IntStream.range(0, BigInteger.valueOf(2).pow(n - 1).intValue())
                .mapToObj(i -> toComposition(n, i)).toArray(int[][]::new);
    }

}
