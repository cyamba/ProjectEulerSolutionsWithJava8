package com.seewhy.common.collections;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class Maps {

    public static <T extends Comparable> Map<T, T> inverse(Map<T, T> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getValue(), e -> e.getKey()));
    }

    public static <T extends Comparable> Map<T, T> toMap(T[] array) {
        return IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.toMap(x -> (T) x, x -> array[x]));

    }

    public static <T extends Comparable> Map<T, T> toMap(List<T> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(x -> (T) x, x -> list.get(x)));
    }

    public static <T extends Comparable> List<T> asList(Map<T, T> map) {
        Map<T, T> sortedMap = new TreeMap(map);
        return sortedMap.entrySet().stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
    }
}
