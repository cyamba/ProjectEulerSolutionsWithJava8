package com.seewhy.solutions.euler98;

import com.seewhy.math.Sets;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;
import com.seewhy.solutions.euler54.poker.Tuple;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.seewhy.common.util.NumberStringConversions.longToStringArray;
import static com.seewhy.common.util.NumberStringConversions.stringToStringArray;
import static com.seewhy.math.MultiPermutations.sameMultiplicity;

/**
 * Created by cbyamba on 2014-04-04.
 */
public class AnagramicSquares2 extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        AnagramicSquares anagramicSquares = new AnagramicSquares();

        List<Long> squares = LongStream.range(10, 100000)
                .map(x -> x * x)
                .boxed()
                .collect(Collectors.toList());

        Map<Long, List<Tuple<String, String>>> anagramsByMatchingSquare = AnagramicSquares.getWordList().parallelStream()
                .collect(Collectors.groupingBy(w -> anagramicSquares.sortedLetters(w)))
                .values().stream()
                .filter(list -> list.size() > 1)
                .flatMap(anagrams -> Sets.subsetsOfSizeTwo_(anagrams))
                .collect(Collectors.groupingBy(tuple -> toMatchingSquare(tuple, squares)));

        return anagramsByMatchingSquare.entrySet().stream()
                .reduce((e1, e2) -> e1.getKey() > e2.getKey() ? e1 : e2)
                .toString();
    }

//    protected String getMaxSquareAsString(Tuple<String, String> maxTuple, List<Long> squares) {
//        return "" + squares.stream()
//                .filter(y -> sameMultiplicity(stringToStringArray(maxTuple._1()), longToStringArray(y)))
//                .mapToLong(y -> y).max().getAsLong();
//    }

    protected Long toMatchingSquare(Tuple<String, String> tuple, List<Long> squares) {
        return squares.stream()
                .filter(y -> sameMultiplicity(stringToStringArray(tuple._1()), longToStringArray(y)))
                .mapToLong(y -> y)
                .max()
                .getAsLong();
    }

    protected boolean hasMatchingSquare(Tuple<String, String> tuple, List<Long> squares) {
        return squares.stream()
                .anyMatch(y -> sameMultiplicity(stringToStringArray(tuple._1()), longToStringArray(y)));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new AnagramicSquares2());
    }


}
