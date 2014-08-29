package com.yambacode.solutions.euler70;

import com.yambacode.solutions.euler65.Fraction;

import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-08-28.
 */
public class Fractions {

    public static final Fraction _0 = Fraction.ZERO;
    public static final Fraction _1 = Fraction.ONE;
    public static final Fraction _2 = Fraction.TWO;
    public static final Fraction _3 = Fraction.THREE;

    public static final Fraction ONE = Fraction.ONE;
    public static final Fraction TWO = Fraction.TWO;
    public static final Fraction THREE = Fraction.THREE;


    public static Fraction multiply(Fraction... fractions) {
        return Stream.of(fractions).reduce((x, product) -> product.multiply(x)).get();
    }
}
