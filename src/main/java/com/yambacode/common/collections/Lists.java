package com.yambacode.common.collections;

import java.util.*;
import java.util.Collections;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-09.
 */
public class Lists {

    public static <T> boolean deepEquals(List<T> list1, List<T> list2) {
        return Arrays.deepEquals(list1.toArray(), list2.toArray());
    }

    public static <T> List<T> copy(List<T> list) {
        return list.stream().collect(toList());
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> List<T> newArrayList(T... elements) {
        return of(elements);
    }

    public static <T> List<T> of(T... elements) {
        return Stream.of(elements).collect(toList());
    }

    public static <T> List<T> of(List<T>... lists) {
        return Stream.of(lists).flatMap(list -> list.stream()).collect(toList());
    }

    public static <T> List<T> of(T value, List<T> list) {
        return of(Stream.of(value).collect(toList()), list);
    }

    public static <T> List<T> tail(List<T> list) {
        return list.stream().skip(1).collect(toList());
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


    public static List<String> shuffle(List<String> list) {
        List<String> copy = copy(list);
        Collections.shuffle(copy);
        return copy;
    }

}
