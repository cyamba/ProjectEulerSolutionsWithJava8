package com.seewhy.common.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-04-03.
 */
public class Strings {
    //TODO move appropriate code from StringToIntegers and NumberStringConversions here that

    public static boolean isNonNullNonEmpty(String string) {
        return string != null && !string.isEmpty();
    }

    public static String[] toLetters(String word) {
        if (isNonNullNonEmpty(word)) {
            return IntStream.range(0, word.length()).boxed()
                    .map(i -> word.substring(i, i + 1))
                    .toArray(x -> new String[word.length()]);
        }
        return new String[0];
    }

    public static String toWord(String[] letters) {
        return Stream.of(letters).collect(Collectors.joining());
    }
}
