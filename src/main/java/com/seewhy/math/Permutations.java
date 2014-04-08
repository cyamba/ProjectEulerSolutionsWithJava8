package com.seewhy.math;


import com.seewhy.common.collections.Arrays1D;
import com.seewhy.common.collections.Maps;
import com.seewhy.common.io.Printer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.seewhy.common.util.CollectionConversion.toLong2dArray;
import static com.seewhy.common.util.NumberStringConversions.longArrayToInt;
import static com.seewhy.common.util.NumberStringConversions.longToLongArray;
import static java.util.Objects.deepEquals;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-21.
 * http://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
 */
public class Permutations {

    public static void printPermutations(Comparable[] permutation) {
        System.out.println(Arrays.toString(permutation));
        while ((permutation = nextPermutation(permutation)) != null) {
            System.out.println(Arrays.toString(permutation));
        }
    }

    public static long[][] generatePermutation(long[] perm) {
        Comparable[] permutation = LongStream.of(perm).boxed().toArray(x -> new Long[perm.length]);
        Comparable[][] result = new Long[Combinatorics.faculty(perm.length).intValue()][perm.length];
        int i = 0;
        while ((permutation = nextPermutation(permutation)) != null) {
            result[i++] = Arrays.copyOf(permutation, result[0].length);
        }
        return toLong2dArray(result);
    }

    public static Comparable[][] generatePermutation(Comparable[] permutation) {
        Comparable[][] result = new Comparable[Combinatorics.faculty(permutation.length).intValue()][permutation.length];
        int i = 0;
        result[i++] = Arrays.copyOf(permutation, permutation.length);
        while ((permutation = nextPermutation(permutation)) != null) {
            result[i++] = Arrays.copyOf(permutation, permutation.length);
        }
        return result;
    }

    public static Collection<Comparable[]> generatePermutationCollection(final Comparable[] perm) {
        Comparable[] permutation = Stream.of(perm).sorted((x, y) -> x.compareTo(y)).toArray(x -> new Comparable[perm.length]);
        Collection<Comparable[]> permutations = new ArrayList<>();
        permutations.add(Arrays.copyOf(permutation, permutation.length));
        while ((permutation = nextPermutation(permutation)) != null) {
            permutations.add(Arrays.copyOf(permutation, permutation.length));
        }
        return permutations;
    }

    private static Comparable[] nextPermutation(final Comparable[] permutation) {
        int first = getFirst(permutation);
        if (first == -1) return null; // no greater permutation
        int toSwap = permutation.length - 1;
        while (permutation[first].compareTo(permutation[toSwap]) >= 0)
            --toSwap;
        swap(permutation, first++, toSwap);
        toSwap = permutation.length - 1;
        while (first < toSwap)
            swap(permutation, first++, toSwap--);
        return permutation;
    }

    private static int getFirst(final Comparable[] permutation) {
        for (int i = permutation.length - 2; i >= 0; --i)
            if (permutation[i].compareTo(permutation[i + 1]) < 0)
                return i;
        return -1;
    }

    private static void swap(final Comparable[] permutation, final int i, final int j) {
        final Comparable tmp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = tmp;
    }

    public static boolean arePermutations(Long... args) {
        return of(args).mapToLong(x -> toSortedDigitsLong(x)).allMatch(x -> x == toSortedDigitsLong(args[0]));
    }

    private static long toSortedDigitsLong(Long original) {
        return longArrayToInt(LongStream.of(longToLongArray(original)).sorted().toArray());
    }

    public static Comparable[] invert(Comparable[] permutation) {
        List<Integer> permutationAsList = Stream.of(permutation)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.toList());
        return IntStream.range(0, permutationAsList.size())
                .map(x -> permutationAsList.indexOf(x))
                .boxed()
                .toArray(x -> new Integer[permutationAsList.size()]);
    }

    public static void main(String... args) {
        Printer.print(generatePermutation(new long[]{1l, 2l, 3l, 4l, 5l}));

        String[] o = {"I", "N", "T", "R", "O", "D", "U", "C", "E"};
        String[] a = {"R", "E", "D", "U", "C", "T", "I", "O", "N"};
        Printer.print(diff(o, a));
        Integer[] permutationDiff = diff(o, a);
        Printer.print(permutationDiff);
        Integer[] factor = {3, 8, 5, 6, 7, 2, 0, 4, 1};
        Comparable[] result = multiply(o, factor);
        Printer.print(result);
    }

        /*
        0 1 2 3 4 5 6 7 8   -> 0 1 2 3 4 5 6 7 8
        I N T R O D U C E   -> R E D U C T I O N
         */
    //1. i Permutation gör en funktion som tar två Comparable och returnerar heltalspermutationen från 0 till n-1 som denna motsvarar
    //2. Givet en Comparable och en heltalspermutation från 0 till n-1 returnera  den resulterande permutationen om dessa väljs som index.

    public static Integer[] diff(Comparable[] original, Comparable[] anagram) {
        return (!arePermutations(original, anagram)) ?
                null
                : IntStream.range(0, original.length).boxed()
                .map(i -> Maps.inverse(Maps.toMap(original)).get(anagram[i])).toArray(x -> new Integer[original.length]);
    }

    public static Permutation<Integer> diff(Word original, Word anagram) {
        Integer[] diff = diff(original.get(), anagram.get());
        return Permutation.of(diff);
    }

    public static Comparable[] multiply(Comparable[] original, Integer[] factor) {
        checkIndicesPermutation(factor);
        return (com.seewhy.common.collections.Objects.containsNull(original, factor)
                || original.length != factor.length) ?
                null
                : IntStream.range(0, factor.length)
                .boxed()
                .map(i -> original[factor[i]])
                .toArray(x -> new Comparable[factor.length]);
    }

    public static Word multiply(Word original, Permutation<Integer> factor) {
        Comparable[] product = multiply(original.get(), factor.get());
        return Word.of(product);
    }

    protected static void checkIndicesPermutation(Integer[] factor) {
        int[] identity = IntStream.range(0, factor.length).toArray();
        int[] sorted = Stream.of(factor).sorted().mapToInt(x -> x).toArray();
        if (!Arrays1D.deepEquals(identity, sorted)) {
            throw new IllegalArgumentException("must be a permutation between 0 and n-1. I Recommend toIndicesPermutation");
        }
    }

    protected static void checkIfNonMultiPermutation(Comparable[] permutation) {
        Comparable[] sorted = Stream.of(permutation).sorted().toArray(x -> new Comparable[permutation.length]);
        IntStream.range(0, sorted.length - 1).forEachOrdered(
                i -> {
                    if (sorted[i] == sorted[i + 1]) {
                        throw new IllegalArgumentException("should not have repeated elements");
                    }
                }
        );
    }

    /**
     * 1357 -> 0123
     * ABCD -> 0123
     *
     * @param permutation
     * @return
     */
    public static Integer[] toIndicesPermutation(Comparable[] permutation) {
        int length = permutation.length;
        Comparable[] permutationSorted = Stream.of(permutation)
                .sorted()
                .toArray(x -> new Comparable[length]);
        Integer[] diff = diff(permutationSorted, permutation);
        Integer[] identity = IntStream.range(0, length).boxed().toArray(x -> new Integer[length]);
        return Stream.of(multiply(identity, diff)).toArray(x -> new Integer[length]);
    }

    public static boolean arePermutations(Comparable[] original, Comparable[] anagram) {
        return com.seewhy.common.collections.Objects.containsNull(original, anagram) ?
                false :
                deepEquals(Stream.of(original).sorted().toArray(), Stream.of(anagram).sorted().toArray());
    }


}
