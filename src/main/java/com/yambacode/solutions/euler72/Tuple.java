package com.yambacode.solutions.euler72;

/**
 * Created by cbyamba on 2014-02-15.
 */
public class Tuple {
    private long n;
    private long k;

    public Tuple(long n, long k) {
        this.n = n;
        this.k = k;
    }

    public long getK() {
        return k;
    }

    public long getN() {
        return n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (k != tuple.k) return false;
        if (n != tuple.n) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (k ^ (k >>> 32));
        result = 31 * result + (int) (n ^ (n >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", n, k);
    }
}
