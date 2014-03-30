package com.seewhy.solutions.euler59;

import com.seewhy.common.collections.LongStreams;
import com.seewhy.common.io.Java8Reader;
import com.seewhy.common.io.Printer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-30.
 */
public class RawComputation {

    public static Long compute(List<Character> key) {
        String text = Java8Reader.reader(XORDecryption.CIPHER)
                .lines()
                .collect(Collectors.joining());

        char[] charKey = new char[key.size()];
        for (int i = 0; i < charKey.length; i++) {
            charKey[i] = key.get(i);
        }

        char[] chars = text.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = chars[i] ^ charKey[i % charKey.length];
        }
        return IntStream.of(ints).mapToLong(x -> x).sum();
    }

    public static void main(String[] args) {
        Printer.print(" test : " + ('*' ^ 'A'));
    }
}
