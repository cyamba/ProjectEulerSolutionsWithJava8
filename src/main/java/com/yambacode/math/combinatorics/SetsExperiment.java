package com.yambacode.math.combinatorics;

import com.yambacode.common.io.Printer;
import com.yambacode.math.Primes;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.yambacode.math.combinatorics.Sets.subsetsFixedSize;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by cbyamba on 2014-02-07.
 */
public class SetsExperiment {

    /**
     * @param sets
     * @param originalSet
     * @param element
     * @return
     */
//    public static BigInteger index(List<List<Integer>> sets, List<Integer> originalSet, Integer element) {
//        int higher = originalSet.size();
//        int lower = higher - element;
//        int k = sets.stream().findFirst().get().size();
//        BigInteger i = Combinatorics.diffOfCombinationSumsOverFixK(higher, lower, k);
//        return i;
//    }

    /**
     * @param sets
     * @param originalSet
     * @param element
     * @return
     */
    public static int index(List<List<Integer>> sets, List<Integer> originalSet, Integer element) {
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


    //TODO unit tests on this
    public static void main(String... args) {
        List<Integer> originalSet = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> sets = subsetsFixedSize(originalSet, 3)
                .stream()
                .map(set -> set.stream().collect(Collectors.toList()))
                .collect(Collectors.toList());

        Printer.print(sets.stream().toArray());
        Object[] objects = sets.stream().filter(list -> !list.contains(1)).toArray();
        Printer.print("all sets except 1 count = " + objects.length);
        Integer index = index(sets, originalSet, 2);
        Printer.print("index = " + index.toString());

        Printer.print(objects);
        Printer.print(sets.stream().skip(index.longValue()).toArray());

        long[] longs = Primes.generatePrimesByCount(50);
        List<Integer[]> integers = subsetsOfFixedK(LongStream.of(longs)
                .mapToObj(x -> x)
                .mapToInt(x -> Integer.valueOf("" + x))
                .boxed()
                .toArray(x -> new Integer[50]));
        integers.stream().forEach(arr -> Printer.print(arr));
    }

    public static List<Integer[]> subsetsOfFixedK(Integer[] originalSet) {
        List<Integer[]> result = new LinkedList<>();
        for (int i = 4; i < originalSet.length; i++) {
            for (int j = 3; j < i; j++) {
                for (int k = 2; k < j; k++) {
                    for (int l = 1; l < k; l++) {
                        for (int m = 0; m < l; m++) {
                            result.add(new Integer[]{
                                    originalSet[i],
                                    originalSet[j],
                                    originalSet[k],
                                    originalSet[l],
                                    originalSet[m]});
                        }
                    }
                }
            }
        }
        return result;
    }

    public static Set<TreeSet<Integer>> subsetsOfFourElements(List<Integer> originalSet) {
        Set<TreeSet<Integer>> result = new LinkedHashSet<>();
        for (int i = 4; i < originalSet.size(); i++) {
            for (int j = 3; j < i; j++) {
                for (int k = 2; k < j; k++) {
                    for (int l = 1; l < k; l++) {
                        result.add(new TreeSet<Integer>(Arrays.asList(
                                originalSet.get(i),
                                originalSet.get(j),
                                originalSet.get(k),
                                originalSet.get(l))));
                    }
                }
            }
        }
        return result;
    }

    public static Set<TreeSet<Integer>> subsetsOfFiveElements(List<Integer> originalSet) {
        Set<TreeSet<Integer>> result = new LinkedHashSet<>();
        for (int i = 4; i < originalSet.size(); i++) {
            for (int j = 3; j < i; j++) {
                for (int k = 2; k < j; k++) {
                    for (int l = 1; l < k; l++) {
                        for (int m = 0; m < l; m++) {
                            result.add(new TreeSet<Integer>(Arrays.asList(
                                    originalSet.get(i),
                                    originalSet.get(j),
                                    originalSet.get(k),
                                    originalSet.get(l),
                                    originalSet.get(m))));
                        }
                    }
                }
            }
        }
        return result;
    }
}
