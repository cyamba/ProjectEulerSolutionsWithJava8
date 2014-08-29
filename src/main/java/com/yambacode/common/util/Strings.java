package com.yambacode.common.util;

import com.yambacode.common.collections.Lists;

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

    public static String of(long number) {
        return String.valueOf(number);
    }

    public String _(long number) {
        return String.valueOf(number);
    }

    public static String toWord(String[] letters) {
        return Stream.of(letters).collect(Collectors.joining());
    }

    public static String shuffle(String word) {
        return Lists.shuffle(Lists.of(toLetters(word))).stream().collect(Collectors.joining());
    }

}
