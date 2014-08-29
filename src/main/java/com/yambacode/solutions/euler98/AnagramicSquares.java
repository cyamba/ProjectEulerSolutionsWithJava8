package com.yambacode.solutions.euler98;

import static com.yambacode.common.io.Java8Reader.*;

import com.yambacode.common.util.NumberStringConversions;
import com.yambacode.math.MultiPermutations;
import com.yambacode.math.Permutations;
import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.solutions.EulerRunner.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-02-15.
 */
public class AnagramicSquares extends AbstractEulerSolver {

    public static final String REGEX = "\",\"" + "|" + "\"";

    public static final String FILE_NAME = "/Users/cbyamba/programming" +
            "/github/EulerSolutionsWithJava8" +
            "/src/main/resources" +
            "/com.seewhy.solutions.euler98" +
            "/words.txt";

    @Override
    public String doSolve() {
        List<String> words = getWordList();
        int size = words.stream().mapToInt(s -> s.length()).max().getAsInt();

        Map<String, List<String>> anagramPairs = words.stream().collect(Collectors.groupingBy(this::sortedLetters));

        List<List<String>> pureAnagrams = anagramPairs.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());

        Map<Integer, List<List<String>>> anagramsByLength = pureAnagrams.stream().collect(Collectors.groupingBy(list -> list.get(0).length()));

        Integer max = anagramsByLength.keySet().stream().sorted(Comparator.<Integer>reverseOrder()).findFirst().get();

        List<List<String>> maxAnagrams = anagramsByLength.get(max);

        Map<Object, List<Integer>> squaresBySortedDigits = IntStream.range((int) Math.pow(10, max / 2), (int) Math.pow(10, max / 2 + 1))
                .map(x -> x * x)
                .boxed()
                .filter(y -> y.toString().length() == max)
                .collect(Collectors.groupingBy(x -> integerToDigits(x)));

        int length = maxAnagrams.get(0).size();
        Integer[] permutationDiff = Permutations
                .diff(maxAnagrams.get(0).toArray(new String[length]),
                        maxAnagrams.get(0).toArray(new String[length]));

        List<String[]> correctMultiplicitySquares = squaresBySortedDigits.entrySet().stream()
                .map(e -> e.getKey().toString())
                .map(s -> NumberStringConversions.stringToStringArray(s))
                .filter(ss -> MultiPermutations.sameMultiplicity(ss, maxAnagrams.get(0).toArray(new String[length])))
                .collect(Collectors.toList());


        //TODO givet INTRODUCE finn vilken permutation som ger REDUCTION

        /*
        1 2 3 4 5 6 7 8 9   -> 4 9 6 7 8 3 1 5 2
        I N T R O D U C E   -> R E D U C T I O N
         */
        //1. i Permutation gör en funktion som tar två Comparable och returnerar heltalspermutationen från 0 till n-1 som denna motsvarar
        //2. Givet en Comparable och en heltalspermutation från 0 till n-1 returnera  den resulterande permutationen om dessa väljs som index.

        return Arrays.deepToString(words.toArray())
                + "\n" + size
                + "\n" + Arrays.deepToString(anagramPairs.entrySet().toArray())
                + "\n" + Arrays.deepToString(pureAnagrams.toArray())
                + "\n" + Arrays.deepToString(anagramsByLength.entrySet().toArray())
                + "\n" + Arrays.deepToString(maxAnagrams.toArray())
                + "\n" + Arrays.deepToString(squaresBySortedDigits.entrySet().toArray())
                + "\n" + Arrays.deepToString(permutationDiff)
                + "\n" + Arrays.deepToString(correctMultiplicitySquares.toArray());


        //TODO anagramic squares of length max. match against
        //search for squares of length max.
        //for each square. assign to first max word

    }

    public static List<String> getWordList() {
        return reader(FILE_NAME)
                .lines()
                .flatMap(line -> Stream.of(line.split(REGEX)))
                .filter(word -> word.length() > 0)
                .collect(Collectors.toList());
    }

    protected String integerToDigits(Integer x) {
        return Stream.of(NumberStringConversions.stringToStringArray(x.toString()))
                .sorted()
                .collect(Collectors.joining());
    }

    protected String sortedLetters(String word) {
        return Stream.of(NumberStringConversions.stringToStringArray(word))
                .sorted()
                .collect(Collectors.joining());
    }


    public static void main(String... args) {
        runEulerSolvers(new AnagramicSquares());
    }

}
