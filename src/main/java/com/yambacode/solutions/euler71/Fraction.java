package com.yambacode.solutions.euler71;


import com.yambacode.common.collections.Objects;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by cbyamba on 2014-09-03.
 */
public class Fraction implements Comparable<Fraction> {

    private BigInteger numerator;
    private BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        if (Objects.containsNull(numerator, denominator)) {
            throw new IllegalArgumentException(String.
                    format("Expected non-null arguments. Actual : numerator = %s denominator = %s", numerator, denominator));
        }
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public static Fraction of(long numerator, long denominator) {
        return new Fraction(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public BigDecimal toBigDecimal() {
        return new BigDecimal(numerator).divide(new BigDecimal(denominator));
    }

    @Override
    public int compareTo(Fraction other) {
        return this.toBigDecimal().compareTo(other.toBigDecimal());
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }
}
