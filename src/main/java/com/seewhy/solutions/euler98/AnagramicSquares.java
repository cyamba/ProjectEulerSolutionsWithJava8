package com.seewhy.solutions.euler98;

import static com.seewhy.common.io.Java8Reader.*;

import com.seewhy.solutions.AbstractEulerSolver;

import static com.seewhy.solutions.EulerRunner.*;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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
        return reader(FILE_NAME)
                .lines()
                .flatMap(line -> Stream.of(line.split(REGEX)))
                .filter((String word) -> word.length() > 0)
                .collect(joining(" "));

    }

    public static void main(String... args) {
        runEulerSolvers(new AnagramicSquares());
    }

}
