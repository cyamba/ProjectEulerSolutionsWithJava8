package com.yambacode.experiments.bracelet;

import java.util.Comparator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class Pearls {

    private static final Comparator<String> naturalOrder = Comparator.<String>naturalOrder();
    private static final Comparator<String> reversedOrder = Comparator.<String>reverseOrder();

    /**
     * Example : "ABC" is a substring of "CABCAB" ("CAB"+CAB) and thus "ABC" and "CAB" are "rotation" equivalent
     * Also reverse "ABC" to check for mirror cases of bracelets
     *
     * @param first  ("ABC")
     * @param second ("CAB")
     * @return true if first is a substring of second concatenated with itself.
     */
    public static boolean flattenedEquals(String[] first, String[] second) {
        String secondString = asString(second, naturalOrder);
        String concatSecondString = secondString.concat(secondString);
        return concatSecondString.contains(asString(first, naturalOrder)) || concatSecondString.contains(asString(first, reversedOrder));
    }

    private static String asString(String[] strings, Comparator<String> order) {
        return Stream.of(strings).sorted(order).collect(joining());
    }
}
