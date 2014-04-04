package com.seewhy.common.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static <T> List<T> newArrayList(T... elements) {
        return Stream.of(elements).collect(Collectors.toList());
    }
}
