package com.seewhy.common.util;

import com.seewhy.common.io.Printer;

import java.util.List;

import java.math.BigInteger;
import java.util.Arrays;

import static java.util.stream.Collectors.*;
import static com.seewhy.common.util.UpDownCastArrays.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-01-15.
 */
public class NumberStringConversions {

    public static String[] intToStringArray(int number) {
        String numberStr = String.valueOf(number);
        String[] digits = new String[numberStr.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = numberStr.substring(i, i + 1);
        }
        return digits;
    }

    public static Integer[] stringToIntegerArray(String str) {
        str = str.replace("\n", "");
        Integer[] result = new Integer[str.length()];
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                result[i] = Integer.parseInt(str.substring(i));
            }
            result[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        return result;
    }

    public static String[] longToStringArray(long number) {
        return stringToStringArray(String.valueOf(number));
    }

    public static String[] stringToStringArray(String str) {
        String[] result = new String[str.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = str.substring(i, i + 1);
        }
        return result;
    }

    public static long[] longToLongArray(long number) {
        return Stream.of(longToStringArray(number)).mapToLong(Long::valueOf).toArray();
    }

    public static int[] longToIntArray(long number) {
        return Stream.of(longToStringArray(number)).mapToInt(Integer::valueOf).toArray();
    }

    public static int[] intToIntArray(int number) {
        return Stream.of(intToStringArray(number)).mapToInt(Integer::valueOf).toArray();
    }

    public static int longArrayToInt(long[] digits) {
        String numberStr = LongStream.of(digits).mapToObj(x -> String.valueOf(x)).collect(joining());
        return Integer.valueOf(numberStr);
    }

    public static long longArrayToLong(long[] digits) {
        String numberStr = LongStream.of(digits).mapToObj(x -> String.valueOf(x)).collect(joining());
        return Long.valueOf(numberStr);
    }

    public static int intArrayToInt(int[] digits) {
        String numberStr = IntStream.of(digits).mapToObj(x -> String.valueOf(x)).collect(joining());
        return Integer.valueOf(numberStr);
    }

    public static long comparableArrayToLong(Comparable[] args) {
        String numberStr = Stream.of(args).map(x -> x.toString()).collect(joining());
        return Long.valueOf(numberStr);

    }

    public static Comparable[] longToComparableArray(Long number) {
        return upCast(Stream.of(longToStringArray(number)).mapToLong(Long::valueOf).toArray());
    }

    public static long[] bigIntegerToPrimitiveLongArray(BigInteger number) {
        return Stream.of(stringToStringArray(number.toString())).mapToLong(Long::valueOf).toArray();
    }

    public static List<Integer> bigIntegerToIntegerList(BigInteger number) {
        return Stream.of(stringToStringArray(number.toString()))
                .mapToInt(Integer::new).boxed()
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        Printer.print(Arrays.deepToString(stringToStringArray("12345")));
    }


    public static byte[] listOfCharsToInteger(List<Character> key) {
        byte[] result = new byte[key.size()];
        IntStream.range(0, key.size()).forEachOrdered(x -> {
            char c = key.get(x);
            Integer cc = (int) c;
            result[x] = new Byte(cc.byteValue());
        }
        );
        return result;
    }
}
