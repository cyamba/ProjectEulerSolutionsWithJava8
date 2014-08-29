package com.yambacode.common.util;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-01-17.
 */
public class UpDownCastArrays {

    public static Long[] upCast(long[] arr) {
        return LongStream.of(arr).boxed().collect(toList()).toArray(new Long[arr.length]);
    }

    public static Integer[] upCast(int[] arr) {
        return IntStream.of(arr).boxed().collect(toList()).toArray(new Integer[arr.length]);
    }

    public static int[] downCast(Integer[] arr) {
        return Stream.of(arr).mapToInt(x -> x).toArray();
    }

    public static long[] downCast(Long[] arr) {
        return Stream.of(arr).mapToLong(x -> x).toArray();
    }

}
