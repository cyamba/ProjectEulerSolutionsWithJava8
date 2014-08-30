package com.yambacode.experiments.bracelet;

import com.yambacode.common.io.Printer;

import static java.util.stream.Collectors.joining;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class Pearls {

    /**
     * Example : "ABC" is a substring of "CABCAB" ("CAB"+CAB) and thus "ABC" and "CAB" are "rotation" equivalent
     *
     * @param first  ("ABC")
     * @param second ("CAB")
     * @return true if first is a substring of second concatenated with itself.
     */
    public static boolean flattenedEquals(String[] first, String[] second) {
        String secondString = asString(second);
        String concatSecondString = secondString.concat(secondString);
        String firstString = asString(first);
        String firstStringReversed = asStringReversed(first);
        Printer.print(String.format("first %s secondConcat %s firstReversed %s", firstString, concatSecondString, firstStringReversed));
        return concatSecondString.contains(firstString) ||
                concatSecondString.contains(firstStringReversed);
    }

    private static String asString(String[] strings) {
        return Stream.of(strings).collect(joining());
    }

    private static String asStringReversed(String[] strings) {
        return Stream.of(strings).sorted(Comparator.<String>reverseOrder()).collect(joining());
    }
}
