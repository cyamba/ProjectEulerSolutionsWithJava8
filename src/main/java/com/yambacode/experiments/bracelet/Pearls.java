package com.yambacode.experiments.bracelet;

import static java.util.stream.Collectors.joining;

import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class Pearls {

    /**
     * Example : "ABC" is a substring of "CABCAB" ("CAB"+CAB) and thus "ABC" and "CAB" are "rotation" equivalent
     *
     * @param first ("ABC")
     * @param second ("CAB")
     * @return true if first is a substring of second concatenated with itself.
     */
    public static boolean flattenedEquals(String[] first, String[] second) {
        String secondString = asString(second);
        return secondString.concat(secondString).contains(asString(first));
    }

    private static String asString(String[] strings) {
        return Stream.of(strings).collect(joining());
    }

}
