package com.yambacode.common.collections;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-27.
 */
public class Objects {

    public static <T> Collection<T> requireNonNull(String message, T... objects) {
        return Stream.of(objects)
                .map(o -> java.util.Objects.requireNonNull(o, message))
                .collect(toList());
    }

    public static void main(String[] args) {
        requireNonNull("oops", 1, 2, 3, null, 4, 5, "hello");
    }

    public static <T> boolean containsNull(T... objects) {
        return java.util.Objects.isNull(objects) ? true : Stream.of(objects).anyMatch(java.util.Objects::isNull);
    }

    public static <T> boolean areNotNul(T... objects) {
        return !containsNull(objects);
    }

}
