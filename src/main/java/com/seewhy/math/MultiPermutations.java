package com.seewhy.math;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-04-02.
 * This class handles a more general form of permutations where repetitions of elements are allowed.
 */
public class MultiPermutations {

    public static Comparable[] multipy(Comparable[] multiPermutation, Integer[] factor) {
        return Permutations.multiplyByPermutation(multiPermutation, factor);
    }

    public static boolean sameMultiplicity(Comparable[] first, Comparable[] second) {
        if (com.seewhy.common.collections.Objects.containsNull(first, second)) {
            return false;
        }
        if (first.length != second.length) {
            return false;
        }
        Map<Comparable, Long> firstMap = Stream.of(first)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Comparable, Long> secondMap = Stream.of(second)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String firstAsString = firstMap.entrySet().stream()
                .map(e -> e.getValue()).map(x -> x.toString())
                .collect(Collectors.joining());

        String secondAsString = secondMap.entrySet().stream()
                .map(e -> e.getValue()).map(x -> x.toString())
                .collect(Collectors.joining());

        return firstAsString.equals(secondAsString);
    }

}
