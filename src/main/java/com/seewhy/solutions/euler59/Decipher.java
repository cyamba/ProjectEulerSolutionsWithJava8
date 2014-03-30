package com.seewhy.solutions.euler59;

import com.seewhy.common.io.Printer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-30.
 */
public class Decipher {

    public static List<String> asListOfWords(List<List<String>> deciphering) {
        String[] lines = toString(deciphering).split("\n");
        List<String> words = Stream.of(lines).flatMap(line -> Stream.of(line.split("\\s"))).collect(Collectors.toList());
        return words;
    }

    public static String toString(List<List<String>> deciphering) {
        return deciphering.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.joining(""));
    }
}
