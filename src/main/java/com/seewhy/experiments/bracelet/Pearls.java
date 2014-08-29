package com.seewhy.experiments.bracelet;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class Pearls {

    /**
     * Example : "ABC" is a substring of "CABCAB"
     *
     * @param first
     * @param second
     * @return true if first is a substring of second concatenated with itself.
     */
    public static boolean flattenedEquals(String[] first, String[] second) {
        String firstString = Stream.of(first).collect(Collectors.joining());
        String secondString = Stream.of(second).collect(Collectors.joining());
        String flattenedSecond = secondString.concat(secondString);
        return flattenedSecond.contains(firstString);
    }

}
