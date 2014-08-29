package com.yambacode.solutions.euler48;


import com.yambacode.solutions.AbstractEulerSolver;

import java.math.BigInteger;
import java.util.stream.LongStream;


/**
 * http://projecteuler.net/problem=48
 * <p/>
 * Created by cbyamba on 2014-01-25.
 */
public class SelfPowers extends AbstractEulerSolver {


    @Override
    public String doSolve() {
        String numberStr = LongStream
                .rangeClosed(1, 1000)
                .mapToObj(x -> BigInteger.valueOf(x).pow((int) x))
                .reduce(BigInteger.ZERO, (x, y) -> x.add(y))
                .toString();
        return numberStr.substring(numberStr.length() - 10);
    }

    public static void main(String... args) {
        new SelfPowers().solve();
    }
}
