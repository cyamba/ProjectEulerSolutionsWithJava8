package com.yambacode.solutions.euler54.poker;

/**
 * Created by cbyamba on 2014-02-22.
 */
public class Tuple<T, U> {
    private T first;
    private U second;

    private Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> Tuple<T, U> of(T first, U second) {
        return new Tuple<>(first, second);
    }

    public static <T, U> Tuple<T, U> tuple(T first, U second) {
        return new Tuple<>(first, second);
    }

    public T _1() {
        return first;
    }

    public U _2() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (first != null ? !first.equals(tuple.first) : tuple.first != null) return false;
        if (second != null ? !second.equals(tuple.second) : tuple.second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s]", first.toString(), second.toString());
    }
}
