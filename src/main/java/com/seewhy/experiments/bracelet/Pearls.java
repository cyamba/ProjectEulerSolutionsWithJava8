package com.seewhy.experiments.bracelet;

import static java.util.stream.Collectors.joining;

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
        String firstString = Stream.of(first).collect(joining());
        String secondString = Stream.of(second).collect(joining());
        String flattenedSecond = secondString.concat(secondString);
        return flattenedSecond.contains(firstString);
    }

}
