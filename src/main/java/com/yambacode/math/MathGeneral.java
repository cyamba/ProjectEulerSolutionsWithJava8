package com.yambacode.math;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-01-07.
 */
public class MathGeneral {


    public static long sumOfSquares(int n) {
        return (long) n * (n + 1) * (2 * n + 1) / 6;
    }

    public static long squareOfArithmeticSum(int n) {
        return (long) Math.pow((n * (n + 1) / 2), 2);
    }


}
