package com.seewhy.math;


import com.seewhy.common.io.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.seewhy.common.util.CollectionConversion.toLong2dArray;
import static com.seewhy.common.util.NumberStringConversions.longArrayToInt;
import static com.seewhy.common.util.NumberStringConversions.longToLongArray;
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
    }

}
