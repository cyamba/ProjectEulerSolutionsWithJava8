package com.yambacode.math.combinatorics;

import static com.yambacode.math.YMath.log;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-10-05.
 */
public class Compositions {


    /**
     * @param size   - length of the corresponding bit string
     * @param number - a non negative integer
     * @return - an int array representing the composition
     */
    public static int[] toComposition(int size, int number) {
        if (number < 0 || size < 0
                || log(number, 2) > size //number is too big
                ) {
            return new int[]{};
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
     * @param n - a non negative integer
     * @return - an array of all compositions of n
     */
    public static int[][] compositionsOf(int n) {
        if (n < 0) {
            return new int[][]{};
        }
        return IntStream.range(0, BigInteger.valueOf(2).pow(n - 1).intValue())
                .mapToObj(i -> toComposition(n, i)).toArray(int[][]::new);
    }

}
