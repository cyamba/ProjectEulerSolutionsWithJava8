package com.yambacode.math.combinatorics;

import com.yambacode.common.io.Printer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-10-05.
 */
public class Compositions {


    public static List<Integer> toComposition(int length, int number) {
        if (length < 0 || number < 0) {
            throw new IllegalArgumentException("length and number must be non negative integers");
        }
        if (BigInteger.valueOf(number).compareTo(BigInteger.valueOf(2).pow(length)) > 0) {
            throw new IllegalArgumentException("number is too big");
        }
        List<Integer> composition = new ArrayList<>();
        int i = 0;
        while (i < length) {
            Integer part = 1;
            while (((number >>> i) & 1) == 1) {
                part += 1;
                i++;
            }
            composition.add(part);
            i++;
        }
        return composition;
    }

    public static List<List<Integer>> compositionsOf(int n) {
        return IntStream.range(0, BigInteger.valueOf(2).pow(n - 1).intValue())
                .mapToObj(i -> toComposition(n, i))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(compositionsOf(20));
    }
}
