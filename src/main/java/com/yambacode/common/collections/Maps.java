package com.yambacode.common.collections;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class Maps {

    public static Map<Comparable, Comparable> inverse(Map<Comparable, Comparable> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getValue(), e -> e.getKey()));
    }

    public static Map<Comparable, Comparable> toMap(Comparable[] array) {
        return IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> array[i]));
    }

    public static <K, V> Map<Set<K>, V> newMultiMap(K... array) {
        return new HashMap<>();
    }

    public static Comparable[] toArray(Map<Integer, Comparable> map) {
        return map.values().stream().toArray(x -> new Comparable[map.values().size()]);
    }

    public static <T extends Comparable> List<T> asList(Map<T, T> map) {
        Map<T, T> sortedMap = new TreeMap(map);
        return sortedMap.entrySet().stream()
                .map(e -> e.getValue())
                .collect(toList());
    }
}
