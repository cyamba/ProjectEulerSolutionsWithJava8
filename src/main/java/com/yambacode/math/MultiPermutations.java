package com.yambacode.math;

import com.yambacode.common.collections.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-04-02.
 * This class handles a more general form of permutations where repetitions of elements are allowed
 * <p/>
 * X 01234567
 * Y AABBABCC   f: X -> Y
 * <p/>
 * f(0)=f(1)
 */
public class MultiPermutations {


    public static Word multiply(Word word, Permutation permutation) {
        return Word.of(Permutations.multiply(word.get(), permutation.getAsIntegers()));
    }

    public static boolean sameMultiplicity(Comparable[] first, Comparable[] second) {
        if (com.yambacode.common.collections.Objects.containsNull(first, second)) {
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

    //it would be cool to have filterMap that is map if some criteria otherwhile omit. Essentially like a compound function of filter and map
    //it could be called .mapIf(Predicate<T> p,Function<T,T> f) and mapToIntIf(Predicate<Integer>,IntFunction f) etc

    /*
        //TODO find all permutations for a given multipermutation product
    protected boolean hasPermutation(Tuple<String, String> tuple, Long y) {
        //TODO string->string <-> square->square
        return MultiPermutations.multipy(stringToStringArray(tuple._1()), longToIntegerArray(y)) == stringToStringArray(tuple._2());
     */

    /**
     * ax=b x is xs proper permutation. xs and b is xs multipermutation.
     *
     * @param xs
     * @return
     */
    public static Map<Word, List<Permutation>> getPermutationMapping(final Word xs) {

        Integer[] original = IntStream.range(0, xs.count()).boxed().toArray(x -> new Integer[xs.count()]);

        List<Permutation> permutations = Permutations.generatePermutationCollection(original).stream()
                .map(ps -> Stream.of(ps).toArray(x -> new Integer[ps.length]))
                .map(is -> Permutation.of(is))
                .collect(Collectors.<Permutation>toList());

        Map<Word, List<Permutation>> result = permutations.stream()
                .collect(Collectors.groupingBy(p -> Permutations.multiply(xs, p)));

        return result;
    }

    /**
     * solves permutation equation ax = b
     *
     * @return
     */
    public static List<Permutation> getFactorsForPermutation(final Word a, Word b) {
        if (a.count() != b.count()) {
            return Lists.newArrayList();
        }
        List<Permutation> factors = getPermutationMapping(a).get(b);
        return factors == null ? Lists.newArrayList() : factors;
    }


    public static String[] multipy(String[] multiPermutation1, Integer[] integers) {
        return multiply(Word.of(multiPermutation1), Permutation.of(integers)).getAsStrings();
    }
}
