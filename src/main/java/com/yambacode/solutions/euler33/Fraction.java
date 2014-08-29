package com.yambacode.solutions.euler33;

/**
 * Created by cbyamba on 2014-01-15.
 */
public class Fraction {

    public static final Fraction ONE = new Fraction(1, 1);

    private int x;
    private int y;

    public Fraction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.x * other.x, this.y * other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (x != fraction.x) return false;
        if (y != fraction.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", x, y);
    }
}
