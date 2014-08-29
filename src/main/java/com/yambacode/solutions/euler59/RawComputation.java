package com.yambacode.solutions.euler59;

import com.yambacode.common.io.Java8Reader;
import com.yambacode.common.io.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        String[] asciiSymbols = text.split("" + ',');
        char[] symbols = new char[asciiSymbols.length];
        for (int i = 0; i < asciiSymbols.length; i++) {
            symbols[i] = (char)(Integer.valueOf(asciiSymbols[i]).intValue());
        }

        int[] symbolsAsIntegers = new int[symbols.length];
        for (int i = 0; i < symbolsAsIntegers.length; i++) {
            symbolsAsIntegers[i] = symbols[i] ^ charKey[i % charKey.length];
        }
        //TODO optimize everything in XORDecryption
        //String collect = IntStream.of(symbolsAsIntegers).mapToObj(x -> Character.valueOf((char) x).toString()).collect(Collectors.joining());
        return IntStream.of(symbolsAsIntegers).mapToLong(x -> x).sum();
    }

    public static void main(String[] args) {
        compute(Arrays.asList('g', 'o', 'd'));
        Printer.print(" test : " + ('*' ^ 'A'));
    }
}
