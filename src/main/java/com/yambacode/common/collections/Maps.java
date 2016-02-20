package com.yambacode.common.collections;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class Maps {

    public static <S, T extends Comparable> Map<T, S> inverse(Map<S, T> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getValue(), e -> e.getKey()));
    }

    public static <T extends Comparable> Map<Integer, T> toMap(T[] array) {
        return IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> array[i]));
    }


    public static <T extends Comparable> List<T> asList(Map<T, T> map) {
        Map<T, T> sortedMap = new TreeMap(map);
        return sortedMap.values().stream().collect(toList());
    }
}
