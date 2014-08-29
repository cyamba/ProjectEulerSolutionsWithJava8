package com.yambacode.solutions.euler39;

/**
 * Created by cbyamba on 2014-01-29.
 */
public class Triple {

    private int a;
    private int b;
    private int c;

    public Triple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple triple = (Triple) o;

        if (a != triple.a) return false;
        if (b != triple.b) return false;
        if (c != triple.c) return false;

        return true;
    }

    public Integer getPerimeter() {
        return a + b + c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s,%s)", a, b, c);
    }
}
