package com.yambacode.math;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2014-09-17.
 */
public class Sums {

    public static int arithmeticSum(Integer n) {
        if (n < 0 || n == null)
            throw new IllegalArgumentException("n must be a non negative integer");
        return (int) (Math.floor((double) (n * (n + 1) / 2.0)));
    }

    public static int getSumOfSquares(Integer n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    public static int getSquareOfSums(Integer n) {
        return n * n * (n + 1) * (n + 1) / 4;
    }

    public static int getSumOfTriples(Integer... triple) {
        if (triple == null || triple.length != 3)
            return 0;
        return triple[0] + triple[1] + triple[2];
    }

    public static BigInteger triangleNumber(final BigInteger n) {
        return n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
    }

    public static Integer sumOfProperDivisors(Integer number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static long sumOfOddSquares(long n) {
        return n * (2 * n - 1) * (2 * n + 1) / 3;
    }


}
