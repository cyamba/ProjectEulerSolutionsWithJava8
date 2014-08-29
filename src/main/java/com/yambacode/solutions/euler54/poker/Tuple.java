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
    public String toString() {
        return String.format("%s,%s", first.toString(), second.toString());
    }
}
