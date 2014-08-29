package com.yambacode.solutions.euler97;

import com.yambacode.common.io.Printer;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-08-23.
 */
public class BigIntegers {

    public static final BigInteger _0 = BigInteger.ZERO;
    public static final BigInteger _1 = BigInteger.ONE;
    public static final BigInteger _2 = BigInteger.valueOf(2);
    public static final BigInteger _3 = BigInteger.valueOf(3);
    public static final BigInteger _4 = BigInteger.valueOf(4);
    public static final BigInteger _5 = BigInteger.valueOf(5);
    public static final BigInteger _6 = BigInteger.valueOf(6);
    public static final BigInteger _7 = BigInteger.valueOf(7);
    public static final BigInteger _8 = BigInteger.valueOf(8);
    public static final BigInteger _9 = BigInteger.valueOf(9);
    public static final BigInteger _10 = BigInteger.valueOf(10);

    public static final BigInteger ONE = BigInteger.ONE;
    public static final BigInteger TWO = BigInteger.valueOf(2);
    public static final BigInteger THREE = BigInteger.valueOf(3);
    public static final BigInteger FOUR = BigInteger.valueOf(4);
    public static final BigInteger FIVE = BigInteger.valueOf(5);
    public static final BigInteger SIX = BigInteger.valueOf(6);
    public static final BigInteger SEVEN = BigInteger.valueOf(7);
    public static final BigInteger EIGHT = BigInteger.valueOf(8);
    public static final BigInteger NINE = BigInteger.valueOf(9);
    public static final BigInteger TEN = BigInteger.valueOf(10);


    public static BigInteger _(long val) {
        return BigInteger.valueOf(val);
    }

    public static BigInteger priorPrime(BigInteger number) {
        Printer.print("searching for a prime less than " + number);
        /*long startLong;
        BigInteger startBigInteger;
        if (number.compareTo(_(Long.MAX_VALUE)) <= 0) {
            startLong = number.longValue();
        } else {
            startBigInteger = number;
        }*/
        BigInteger tmp = number.subtract(_1);
        while (!tmp.isProbablePrime(20)) {
            tmp = tmp.subtract(_1);
        }
        return tmp;
    }

    public static BigInteger _decrement(BigInteger number) {
        return number.subtract(_1);
    }


    public static BigInteger _increment(BigInteger number) {
        return number.add(_1);
    }

    public static BigInteger multiply(BigInteger... numbers) {
        return Stream.of(numbers).reduce((k, product) -> k.multiply(product)).get();
    }


}
