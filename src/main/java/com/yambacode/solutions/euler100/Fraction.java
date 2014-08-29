package com.yambacode.solutions.euler100;

/**
 * Created by cbyamba on 2014-08-22.
 */
public class Fraction {

    private long numerator;
    private long denominator;

    private Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction of(long numerator, long denominator) {
        return new Fraction(numerator, denominator);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    /**
     * @return < 0 if < 1/2, ==0 if == 1/2, >0 if >1/2
     */
    public long compareToOneHalf() {
        return 2 * numerator - denominator;
    }

    @Override
    public int hashCode() {
        int result = (int) (numerator ^ (numerator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }
}
