package com.seewhy.math;

import java.util.Arrays;

/**
 * Created by cbyamba on 2014-04-08.
 */
public class Permutation<T extends Comparable> {

    private T[] permutation;

    private Permutation(T[] permutation) {
        this.permutation = permutation;
    }

    public static <T extends Comparable> Permutation of(T... values) {
        return new Permutation(values);
    }

    public T[] get() {
        return permutation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permutation that = (Permutation) o;

        if (!Arrays.deepEquals(permutation, that.permutation)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return permutation != null ? Arrays.deepHashCode(permutation) : 0;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(permutation);
    }
}
