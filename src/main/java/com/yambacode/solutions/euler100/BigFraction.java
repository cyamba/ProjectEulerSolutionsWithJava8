package com.yambacode.solutions.euler100;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by cbyamba on 2014-08-23.
 */
public class BigFraction {
    private BigInteger numerator;
    private BigInteger denominator;

    private BigFraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static BigFraction of(BigInteger numerator, BigInteger denominator) {
        return new BigFraction(numerator, denominator);
    }

    public static BigFraction of(long numerator, long denominator) {
        return new BigFraction(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public int compareToOneHalf() {
        return BigInteger.valueOf(2).multiply(numerator).compareTo(denominator);
    }

    public BigFraction multiply(BigFraction other) {
        return new BigFraction(this.numerator.multiply(other.numerator), this.denominator.multiply(other.denominator));
    }

    public BigDecimal value(){
        return BigDecimal.valueOf(numerator.divide(denominator).longValueExact());
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator.toString(), denominator.toString());
    }
}
