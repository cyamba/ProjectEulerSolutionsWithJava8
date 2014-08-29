package com.yambacode.common.collections;

import junit.framework.Assert;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-15.
 */
public class CollectionAsserts {

    public static <T> void assertEquals(T[] expected, T[] actual) {
        IntStream.range(0, expected.length)
                .forEachOrdered(x -> assertEquals(expected[x], actual[x]));
    }

    public static <T> void assertEquals(T expected, T actual) {
        Assert.assertEquals(expected, actual);
    }
}
