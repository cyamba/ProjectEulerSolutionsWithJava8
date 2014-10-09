package com.yambacode.math.combinatorics;


import com.yambacode.common.io.Printer;
import com.yambacode.solutions.euler54.poker.Tuple;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by cbyamba on 2014-02-05.
 */
public class Sets {


    /**
     * @param sets
     * @param originalSet
     * @param element
     * @return
     */
    public static int index(List<List<Integer>> sets, List<Integer> originalSet, int element) {
        int higher = originalSet.size();
        int lower = higher - element;
        int k = sets.stream().findFirst().get().size();
        BigInteger i = Combinatorics.diffOfCombinationSumsOverFixK(higher, lower, k);
        return i.intValue();
    }

    /**
     * @param originalSet
     * @return
     */
    public static Set<TreeSet<Integer>> subsets(List<Integer> originalSet) {
        if (originalSet.size() == 0) {
            return new HashSet<>();
        }
        Set<TreeSet<Integer>> all = new LinkedHashSet<>();
        Set<TreeSet<Integer>> accu = new LinkedHashSet<>();
        TreeSet<Integer> emptySet = new TreeSet<>();
        all.add(emptySet);
        accu.add(emptySet);
        return subsets0(all, accu, originalSet);
    }

    protected static Set<TreeSet<Integer>> subsets0(Set<TreeSet<Integer>> all, final Set<TreeSet<Integer>> accu, List<Integer> originalSet) {
        if (all.size() >= Math.pow(2, originalSet.size())) {
            return all;
        }
        Set<TreeSet<Integer>> newAccu = IntStream
                .range(0, originalSet.size())
                .parallel()
                .mapToObj(element -> originalSet.get(element))
                .flatMap(y -> merges(y, accu).stream())
                .collect(toSet());
        all.addAll(newAccu);
        return subsets0(all, newAccu, originalSet);
    }

    protected static Set<TreeSet<Integer>> merges(Integer number, Set<TreeSet<Integer>> accu) {
        return accu.parallelStream().map(set -> merge(set, number)).collect(toSet());
    }

    protected static TreeSet<Integer> merge(TreeSet<Integer> set, Integer number) {
        int[] intArr = set.stream().mapToInt(x -> x).toArray();
        int[] result = new int[intArr.length + 1];
        IntStream.range(0, intArr.length).forEach(x -> result[x] = intArr[x]);
        result[result.length - 1] = number;
        return new TreeSet<>(IntStream.of(result).boxed().collect(toList()));
    }

    /**
     * @param originalSet
     * @param k
     * @return
     */
    public static Set<TreeSet<Integer>> subsetsFixedSize(List<Integer> originalSet, int k) {
        //TODO garantee som linkedList order...
        return subsets(originalSet).parallelStream().filter(x -> x.size() == k).collect(toSet());
    }


//    public static Set<TreeSet<Integer>> subsetsFixedSize_(List<Integer> originalSet, int k) {
//        return subsets(originalSet).stream().skip(x -> x.size() == k).collect(toSet());
//    }

    /**
     * TODO instead of filter do a skip and drop based on cardinalities. Then compare benchmarks
     *
     * @param originalSet
     * @return
     */
    public static List<TreeSet<Integer>> subsetsOfSizeTwo(List<Integer> originalSet) {
        return originalSet
                .parallelStream()
                .flatMap(element ->
                        combineWith(
                                originalSet,
                                new TreeSet<Integer>(new ArrayList<>(Arrays.asList(element))),
                                element)
                                .stream())
                .collect(toList());
    }

    protected static List<TreeSet<Integer>> combineWith(List<Integer> originalSet, TreeSet<Integer> set, Integer element) {
        return originalSet
                .stream()
                .skip(element) //TODO derive the correct formula for where start index should be for optimization
                .map(x -> merge(set, x))
                .collect(toList());
    }


    //TODO DO
    public static List<TreeSet<Integer>> subsetsOfSizeThree(List<Integer> originalSet) {
        return null;
    }

    protected static List<TreeSet<Integer>> combineWithSize2(List<Integer> originalSet, TreeSet<Integer> set, Integer element) {
        return originalSet
                .stream()
                .skip(element) //TODO derive the correct formula for where start index should be for optimization
                .map(x -> merge(set, x))
                .collect(toList());
    }

    //TODO DO
    public static List<TreeSet<Integer>> subsetsOfSizeFour(List<Integer> originalSet) {
        return originalSet
                .parallelStream()
                .flatMap(element ->
                        combineWith(
                                originalSet,
                                new TreeSet<Integer>(new ArrayList<>(Arrays.asList(element))),
                                element)
                                .stream())
                .collect(toList());
    }

    public static List<List<Integer>> subsets5(List<Integer> originalSet) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i1 = 4; i1 < originalSet.size(); i1++) {
            for (int i2 = 3; i2 < i1; i2++) {
                for (int i3 = 2; i3 < i2; i3++) {
                    for (int i4 = 1; i4 < i3; i4++) {
                        for (int i5 = 0; i5 < i4; i5++) {
                            result.add(putInSet(i1, i2, i3, i4, i5));
                        }
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer> putInSet(int... values) {
        return IntStream.of(values).boxed().collect(Collectors.toList());
    }


    public static void main(String... args) {
        List<Integer> originalSet = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Set<TreeSet<Integer>> sets = subsets(originalSet);
        Printer.print(String.format("----- Printing all %s subsets of %s ------", sets.size(), Arrays.toString(originalSet.toArray())));
        Printer.print(sets);
        Printer.print();
        //List<Integer> originalSetFixed = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> originalSetFixed = IntStream.range(1, 1000).boxed().collect(toList());
        Printer.print(originalSetFixed.size());

        long start = System.currentTimeMillis();
        List<TreeSet<Integer>> setsFixed = subsetsOfSizeTwo(originalSetFixed);
        long end = System.currentTimeMillis();
        Printer.print(String.format("----- Printing all %s subsets of %s ------", setsFixed.size(), Arrays.toString(originalSetFixed.toArray())));
        Printer.print(setsFixed);
        Printer.print("executed time : " + (end - start));
    }

    public static <T> Stream<Tuple<T, T>> subsetsOfSizeTwo_(List<T> anagrams) {
        return IntStream.range(1, anagrams.size()).boxed().flatMap(
                i -> IntStream.range(0, i).mapToObj(
                        j -> Tuple.tuple(anagrams.get(i), anagrams.get(j))
                )
        );
    }

}
