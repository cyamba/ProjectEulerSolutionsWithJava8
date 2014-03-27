package com.seewhy.common.collections;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-27.
 */
public class Objects {

    public static <T> Collection<T> requireNonNull(String message, T... objects) {
        return Stream.of(objects)
                .map(o -> java.util.Objects.requireNonNull(o, message))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        requireNonNull("oops", 1, 2, 3, null, 4, 5, "hello");
    }
}
