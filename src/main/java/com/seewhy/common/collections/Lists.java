package com.seewhy.common.collections;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-09.
 */
public class Lists {

    public static <T> boolean deepEquals(List<T> list1, List<T> list2) {
        return Arrays.deepEquals(list1.toArray(), list2.toArray());
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> List<T> of(T... elements) {
        return Stream.of(elements).collect(Collectors.toList());
    }

    public static <T> List<T> of(List<T>... lists) {
        return Stream.of(lists).flatMap(list -> list.stream()).collect(Collectors.toList());
    }

    public static <T> List<T> of(T value, List<T> list) {
        return of(Stream.of(value).collect(Collectors.toList()), list);
    }

    public static <T> List<T> tail(List<T> list) {
        return list.stream().skip(1).collect(Collectors.toList());
    }

    public static <T> Optional<T> head(List<T> list) {
        return list.stream().skip(1).findFirst();
    }

    public static <T> Optional<T> findFirst(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).findFirst();
    }

    public static <T> boolean isDistinct(List<T> list) {
        return list.stream().distinct().count() == list.size();
    }


}
