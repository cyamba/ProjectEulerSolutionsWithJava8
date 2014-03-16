package com.seewhy.solutions.euler57;

import com.seewhy.math.Divisibility;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2014-02-21.
 */
public class Fraction {

    public static final Fraction ZERO = new Fraction(BigInteger.ZERO, BigInteger.ONE);

    public static final Fraction ONE = new Fraction(BigInteger.ONE, BigInteger.ONE);

    private BigInteger numerator;

    private BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public double getValue() {
        return numerator.divide(denominator).doubleValue();
    }

    /**
     * a/b + c/d = (b*c+d*a)/(b*d)
     *
     * @param fraction
     * @return
     */
    public Fraction add(Fraction fraction) {
        BigInteger newNumerator = denominator.multiply(fraction.numerator).add(fraction.denominator.multiply(numerator));
        BigInteger newDenominator = denominator.multiply(fraction.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    protected Fraction reduce() {
        BigInteger gcd = Divisibility.gcdBetter(numerator, denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
        return this;
    }

    public Fraction add(BigInteger number) {
        return add(fraction(number));
    }

    public Fraction add(Integer number) {
        return add(BigInteger.valueOf(number));
    }

    public static Fraction fraction(BigInteger numerator, BigInteger denominator) {
        return new Fraction(numerator, denominator);
    }

    public static Fraction fraction(BigInteger number) {
        return new Fraction(number, BigInteger.ONE);
    }

    public static Fraction fraction(Integer number) {
        return fraction(BigInteger.valueOf(number));
    }

    public static Fraction fraction(Integer numerator, Integer denominator) {
        return fraction(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public Fraction inv() {
        return fraction(denominator, numerator);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
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
}
