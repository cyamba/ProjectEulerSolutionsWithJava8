package com.seewhy.solutions.euler65;

import com.seewhy.solutions.euler70.Fractions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Stream;

import static com.seewhy.solutions.euler97.BigIntegers._;
import static com.seewhy.solutions.euler97.BigIntegers._1;

/**
 * Created by cbyamba on 2014-08-24.
 */
public class Fraction {

    private BigInteger numerator;
    private BigInteger denominator;

    public static final Fraction ZERO = of(0, 1);

    public static final Fraction ONE = of(1, 1);

    public static final Fraction TWO = of(2, 1);

    public static final Fraction THREE = of(3, 1);

    public static final Fraction NEGATIVE_ONE = of(-1, 1);

    public Fraction(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public static Fraction of(long numerator, long denominator) {
        return new Fraction(_(numerator), _(denominator));
    }

    public static Fraction of(long n) {
        return of(n, 1);
    }

    public static Fraction of(BigInteger numerator) {
        return new Fraction(numerator, _1);
    }

    public static Fraction of(BigInteger numerator, BigInteger denominator) {
        return new Fraction(numerator, denominator);
    }

    public Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    public Fraction add(Fraction other) {
        BigInteger x1 = other.denominator.multiply(this.numerator);
        BigInteger x2 = this.denominator.multiply(other.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        BigInteger newNumerator = x1.add(x2);
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        return add(Fraction.NEGATIVE_ONE.add(other));
    }

    public Fraction multiply(Fraction other) {
        BigInteger newNumerator = other.numerator.multiply(this.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    public BigInteger toBigInteger() {
        return numerator.divide(denominator);
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public Fraction multiply(Fraction... fractions) {
        return Fractions.multiply(fractions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (!denominator.equals(fraction.denominator)) return false;
        if (!numerator.equals(fraction.numerator)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator.hashCode();
        result = 31 * result + denominator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }
}
