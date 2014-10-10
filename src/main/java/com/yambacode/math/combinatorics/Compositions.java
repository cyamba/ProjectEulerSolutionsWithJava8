package com.yambacode.math.combinatorics;

import static com.yambacode.math.YMath.log;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-10-05.
 */
public class Compositions {


    /**
     * @param size
     * @param number
     * @return
     */
    public static int[] toComposition(int size, int number) {
        if (size < 0 || number < 0) {
            throw new IllegalArgumentException("size and number must be non negative integers");
        }
        if (log(number, 2) > size) {
            throw new IllegalArgumentException("number is too big");
        }
        int[] composition = new int[size - Integer.bitCount(number)];
        int i = 0;
        int j = 0;
        while (i < size) {
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

    /**
     * @param n
     * @return
     */
    public static int[][] compositionsOf(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number must be non negative");
        }
        return IntStream.range(0, BigInteger.valueOf(2).pow(n - 1).intValue())
                .mapToObj(i -> toComposition(n, i)).toArray(int[][]::new);
    }

}
