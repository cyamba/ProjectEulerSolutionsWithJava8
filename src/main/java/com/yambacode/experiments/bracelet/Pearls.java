package com.yambacode.experiments.bracelet;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class Pearls {

    /**
     * Example : "ABC" is a substring of "CABCAB" ("CAB"+CAB) and thus "ABC" and "CAB" are "rotation" equivalent
     * Also reverse "ABC" to check for mirror cases of bracelets
     *
     * @param first  ("ABC")
     * @param second ("CAB")
     * @return true if first is a substring of second concatenated with itself.
     */
    public static boolean flattenedEquals(String[] first, String[] second) {
        String secondString = asString(second);
        String concatSecondString = secondString.concat(secondString);
        String firstString = asString(first);
        return concatSecondString.contains(firstString) || concatSecondString.contains(new StringBuilder(firstString).reverse());
    }

    private static String asString(String[] strings) {
        return Stream.of(strings).collect(joining());
    }
}
