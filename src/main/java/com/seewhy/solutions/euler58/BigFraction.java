package com.seewhy.solutions.euler58;

import com.seewhy.common.io.Printer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created by cbyamba on 2014-03-06.
 */
public class BigFraction {
    public static final int PRECISION = 10;

    private BigInteger numerator;
    private BigInteger denominator;

    private BigFraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static BigFraction bigFraction(BigInteger numerator, BigInteger denominator) {
        return new BigFraction(numerator, denominator);
    }

    public static BigFraction bigFraction(long numerator, long denominator) {
        return bigFraction(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public BigDecimal getValue() {
        BigDecimal y = new BigDecimal(numerator.toString());
        BigDecimal x = new BigDecimal(denominator.toString());
        return y.divide(x, PRECISION, RoundingMode.FLOOR);
    }

    public BigFraction reduce() {
        BigInteger gcd = numerator.gcd(denominator);
        return bigFraction(numerator.divide(gcd), denominator.divide(gcd));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigFraction that = (BigFraction) o;

        if (denominator != null ? !denominator.equals(that.denominator) : that.denominator != null) return false;
        if (numerator != null ? !numerator.equals(that.numerator) : that.numerator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator != null ? numerator.hashCode() : 0;
        result = 31 * result + (denominator != null ? denominator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }

    public static void main(String[] args) {
        BigFraction bigFraction = bigFraction(BigInteger.ONE, BigInteger.valueOf(3));
        String s = bigFraction.toString();
        Printer.print(s);
        Printer.print(bigFraction.getValue().toString());

        BigDecimal number = new BigDecimal("1.0000").divide(new BigDecimal("3.0000"), 5, RoundingMode.FLOOR);
        Printer.print(number.toString());
    }
}
