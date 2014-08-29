package com.yambacode.solutions.euler98;

import com.yambacode.math.*;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler54.poker.Tuple;

import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.yambacode.common.util.NumberStringConversions.*;
import static com.yambacode.math.MultiPermutations.sameMultiplicity;

/**
 * Created by cbyamba on 2014-04-04.
 */
public class AnagramicSquares2 extends AbstractEulerSolver {

    static List<Long> allSquares = LongStream.range(10, 1000000)
            .map(x -> x * x)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public String doSolve() {
        AnagramicSquares anagramicSquares = new AnagramicSquares();

        List<Long> squares = LongStream.range(10, 1000000)
                .map(x -> x * x)
                .boxed()
                .collect(Collectors.toList());

        Map<OptionalLong, List<Tuple<String, String>>> anagramsByMatchingSquare = AnagramicSquares.getWordList().parallelStream()
                .collect(Collectors.groupingBy(w -> anagramicSquares.sortedLetters(w)))
                .values().stream()
                .filter(list -> list.size() > 1)
                .flatMap(anagrams -> Sets.subsetsOfSizeTwo_(anagrams))
                .filter(tuple -> hasMatchingSquare(tuple, squares))
                .collect(Collectors.groupingBy(tuple -> toMatchingSquare(tuple, squares)));

        OptionalLong max = anagramsByMatchingSquare.keySet().stream()
                .filter(x -> x.isPresent())
                .mapToLong(x -> x.getAsLong())
                .max();
        return max + " " + anagramsByMatchingSquare.get(max).toString();
    }

//    protected String getMaxSquareAsString(Tuple<String, String> maxTuple, List<Long> squares) {
//        return "" + squares.stream()
//                .filter(y -> sameMultiplicity(stringToStringArray(maxTuple._1()), longToStringArray(y)))
//                .mapToLong(y -> y).max().getAsLong();
//    }

    protected OptionalLong toMatchingSquare(Tuple<String, String> wordPair, List<Long> squares) {
        return squares.stream()
                .filter(square -> sameMultiplicity(stringToStringArray(wordPair._1()), longToStringArray(square)))
                .filter(square -> hasPermutation(wordPair, square))
                .mapToLong(square -> square)
                .max();
    }

    protected boolean hasPermutation(Tuple<String, String> wordPair, Long square) {
        List<Permutation> factorsForPermutation = MultiPermutations.getFactorsForPermutation(Word.of(wordPair._1()), Word.of(wordPair._2()));
        String[] squareAsArray = longToStringArray(square);
        //unit test and debug
        return factorsForPermutation.stream()
                .map(permutation -> MultiPermutations.multiply(Word.of(squareAsArray), permutation))
                .anyMatch(squareAsWord -> allSquares.contains(comparableArrayToLong(squareAsWord.get())));
    }

    protected boolean hasMatchingSquare(Tuple<String, String> tuple, List<Long> squares) {
        return squares.stream()
                .anyMatch(y -> sameMultiplicity(stringToStringArray(tuple._1()), longToStringArray(y)));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new AnagramicSquares2());
    }


}
