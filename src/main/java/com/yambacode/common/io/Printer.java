package com.yambacode.common.io;


import com.yambacode.common.collections.Arrays2D;
import com.yambacode.solutions.EulerResult;

import java.util.*;

import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.yambacode.common.util.CollectionConversion.mapToCharacterArray;

/**
 * Created by cbyamba on 2014-01-03.
 */
public class Printer {

    public static void print(String o) {
        System.out.println(o);
    }

    public static void print(long[] objects) {
        print(Arrays.deepToString(
                LongStream.of(objects).boxed().toArray()));
    }

    public static void print(char[] objects) {
        print(Arrays.deepToString(mapToCharacterArray(objects)));
    }

    public static void print(LongStream longStream) {
        print(Arrays.deepToString(longStream.mapToObj(x -> new Long(x)).toArray()));
    }

    public static void print(String str, Objects... args) {
        print(String.format(str, args));
    }

    public static void print() {
        System.out.println();
    }

    public static void print(long[][] args) {
        Stream.of(args).forEach(x -> print(x));
    }


    public static void print(Comparable[][] args) {
        Stream.of(args).forEach(x -> print(x));
    }

    public static void print(Collection<Comparable[]> args) {
        args.stream().forEach(x -> print(x));
    }

    private static void print(Comparable[] x) {
        print(Arrays.deepToString(x));
    }

    public static void print(int[][] objects) {
        print(Arrays2D.deepToString(objects));
    }

    public static void print(int i) {
        print("" + i);
    }

    public static void print(long l) {
        print("" + l);
    }

    public static void print(double d) {
        print("" + d);
    }

    public static void print(boolean b) {
        print("" + b);
    }

    public static void print(List<TreeSet<Integer>> objects) {
        print(objects.stream()
                .map(x -> x.stream().mapToInt(y -> y).toArray())
                .map(y -> Arrays.toString(y))
                .collect(joining(",")));
    }


    public static void print(Set<TreeSet<Integer>> objects) {
        print(objects.stream()
                .map(x -> x.stream().mapToInt(y -> y).toArray())
                .map(y -> Arrays.toString(y))
                .collect(joining(",")));
    }

    public static void print(EulerResult result) {
        print(result.toString());
    }

    public static void print(int[] arr) {
        print(IntStream.of(arr).boxed().toArray(a -> new Integer[arr.length]));
    }

    public static void print(Object[] objects) {
        print(Arrays.deepToString(objects));
    }

    public static void print(String msg, int... ints) {
        Object[] args = IntStream.of(ints).boxed().toArray();
        print(String.format(msg, args));
    }
}
